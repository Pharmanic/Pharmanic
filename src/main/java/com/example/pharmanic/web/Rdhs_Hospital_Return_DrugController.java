package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.model.Rdhs_Hospital_Return_Drug;

import com.example.pharmanic.repositories.Rdhs_Hospital_Return_DrugRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Rdhs_Hospital_Return_DrugController {
    private Rdhs_Hospital_Return_DrugRepository rdhs_hospital_return_drugRepository;

    public Rdhs_Hospital_Return_DrugController(Rdhs_Hospital_Return_DrugRepository rdhs_hospital_return_drugRepository) {
       super();
        this.rdhs_hospital_return_drugRepository = rdhs_hospital_return_drugRepository;
    }

    @GetMapping("/rhreturndrug")
    Collection<Rdhs_Hospital_Return_Drug> drugStore() {

        return rdhs_hospital_return_drugRepository.findAll();
    }
    @RequestMapping(value = "/returnCart/{reg_no}", method = RequestMethod.GET)
    List<Rdhs_Hospital_Return_Drug> getReturnCart(@PathVariable("reg_no") String reg_no) {
        return rdhs_hospital_return_drugRepository.findByreturned_id(reg_no);

    }

    @RequestMapping(value = "/returnValCart/{returned_id}", method = RequestMethod.GET)
    Collection<Rdhs_Hospital_Return_Drug> getReturnITem(@PathVariable("returned_id") Long returned_id){
      return   rdhs_hospital_return_drugRepository.findReturnItem(returned_id);
    }


   /* @PostMapping("/svreturndrug")
    ResponseEntity<Rdhs_Hospital_Return_Drug> createExpense(@Validated @RequestBody Rdhs_Hospital_Return_Drug rdhs_hospital_return_drug) throws URISyntaxException {
        Rdhs_Hospital_Return_Drug result = rdhs_hospital_return_drugRepository.save(rdhs_hospital_return_drug);
        System.out.println("In post controller");
        return ResponseEntity.created(new URI("/api/svreturndrug" + result.getReturned_id())).body(result);

    }*/
   @PostMapping("/returndtock")
   ResponseEntity<Rdhs_Hospital_Return_Drug> createReturnDrug(@Validated @RequestBody Rdhs_Hospital_Return_Drug rdhs_hospital_return_drug) throws URISyntaxException {

       System.out.printf(String.valueOf(rdhs_hospital_return_drug));
       Rdhs_Hospital_Return_Drug result = rdhs_hospital_return_drugRepository.save(rdhs_hospital_return_drug);
       return ResponseEntity.created(new URI("/api/returndtock" + result.getReturned_id())).body(result);
   }


    @PutMapping("/updatereturn/{id}")
    ResponseEntity<Rdhs_Hospital_Return_Drug> updateExpense(@Validated @RequestBody Rdhs_Hospital_Return_Drug rdhs_hospital_return_drug) {
        Rdhs_Hospital_Return_Drug result = rdhs_hospital_return_drugRepository.save(rdhs_hospital_return_drug);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/updatereturnqty/{id},{batch}")
    int updateQuantity(@Validated @RequestBody String reg_no, @RequestBody Long batchId) {
        int result = rdhs_hospital_return_drugRepository.updateCart(reg_no,batchId);
        return result;
    }
   /* @PostMapping("/saverhreturndrugs")
    void newRecord(@Validated @RequestBody Date date,int quantity,Long batch_id) throws URISyntaxException {
        System.out.println(quantity);
        System.out.println("c1");
        Integer n1=new Integer(quantity);
     //   int q1=new Integer(quantity);
        System.out.println("c2");


        //System.out.println("qty"+q1);
        System.out.println("batch"+batch_id);
        rdhs_hospital_return_drugRepository.savereturn(date,n1,batch_id);
       // return ResponseEntity.created(new URI("/api/rhreturndrugs" + result.getReturned_id())).body(result);
    }*/



    @DeleteMapping("returnitem/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        rdhs_hospital_return_drugRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
