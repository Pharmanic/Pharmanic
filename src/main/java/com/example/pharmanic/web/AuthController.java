package com.example.pharmanic.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.RdhsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmanic.model.ERole;
import com.example.pharmanic.model.Role;
import com.example.pharmanic.model.User;
import com.example.pharmanic.payload.request.LoginRequest;
import com.example.pharmanic.payload.request.SignupRequest;
import com.example.pharmanic.payload.response.JwtResponse;
import com.example.pharmanic.payload.response.MessageResponse;
import com.example.pharmanic.repositories.RoleRepository;
import com.example.pharmanic.repositories.UserRepository;
import com.example.pharmanic.security.jwt.JwtUtils;
import com.example.pharmanic.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RdhsRepository rdhsRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println("Here" + loginRequest.getPassword());
        System.out.println("Login Begin");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        System.out.println("1");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("2");
        String jwt = jwtUtils.generateJwtToken(authentication);
        System.out.println("3");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(userDetails.getBranch());
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
//        Rdhs rdhs=rdhsRepository.findByName(userDetails.getBranch());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles, userDetails.getBranch())
                );
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//        System.out.println("In SignUp"+signUpRequest.getRole());
//        signUpRequest.setRole();
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),signUpRequest.getBranch());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        System.out.println("Role"+strRoles);

        if (strRoles == null) {
            System.out.println("Null Role");
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    case "mod":
//                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//
//                        break;
//                        ministry users
                    case "ministry_admin":
                        Role ministryAdminRole = roleRepository.findByName(ERole.ministry_admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(ministryAdminRole);

                        break;
                    case "minister":
                        Role ministerRole = roleRepository.findByName(ERole.minister)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(ministerRole);

                        break;
                    case "ministry_stock_keeper":
                        Role ministryStockKeeperRole = roleRepository.findByName(ERole.ministry_stock_keeper)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(ministryStockKeeperRole);

                        break;
//                  ministry store users
                    case "ministry_store_admin":
                        Role ministryStoreAdminRole = roleRepository.findByName(ERole.ministry_store_admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(ministryStoreAdminRole);

                        break;
                    case "ministry_store_stock_keeper":
                        Role ministryStoreStockKeeperRole = roleRepository.findByName(ERole.ministry_store_stock_keeper)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(ministryStoreStockKeeperRole);

                        break;
//                   rdhs users
                    case "rdhs_admin":
                        Role rdhsAdminRole = roleRepository.findByName(ERole.rdhs_admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rdhsAdminRole);
                    case "rdhs_director":
                        Role rdhsDirectorRole = roleRepository.findByName(ERole.rdhs_director)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rdhsDirectorRole);

                        break;
                    case "rdhs_stock_keeper":
                        Role rdhsStockKeeperRole = roleRepository.findByName(ERole.rdhs_stock_keeper)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rdhsStockKeeperRole);

                        break;
                    case "direct_hospital_admin":
                        Role directHospitalAdmin = roleRepository.findByName(ERole.direct_hospital_admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(directHospitalAdmin);

                        break;
                    case "direct_hospital_doctor_incharge":
                        Role directHospitalDoctorIncharge = roleRepository.findByName(ERole.direct_hospital_doctor_incharge)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(directHospitalDoctorIncharge);

                        break;
                    case "direct_hospital_stock_keeper":
                        Role directHospitalStockKeeper = roleRepository.findByName(ERole.direct_hospital_stock_keeper)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(directHospitalStockKeeper);

                        break;
                    case "hospital_by_rdhs_admin":
                        Role hospitalByRDHSAdmin = roleRepository.findByName(ERole.hospital_by_rdhs_admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(hospitalByRDHSAdmin);

                        break;
                    case "hospital_by_rdhs_doctor_incharge":
                        Role hospitalByRDHSDoctorIncharge = roleRepository.findByName(ERole.hospital_by_rdhs_doctor_incharge)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(hospitalByRDHSDoctorIncharge);

                        break;
                    case "hospital_by_rdhs_stock_keeper":
                        Role hospitalByRDHSStockKeeper = roleRepository.findByName(ERole.hospital_by_rdhs_stock_keeper)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(hospitalByRDHSStockKeeper);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
