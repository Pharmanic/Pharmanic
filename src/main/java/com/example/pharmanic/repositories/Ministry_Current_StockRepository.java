package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.QtyYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Ministry_Current_StockRepository extends JpaRepository<Ministry_Current_Stock,Long> {

    @Query(value="{call ministry_store_damage(:id, :quantity)}",nativeQuery=true)
    public void updateDamageStock(@Param("id") Long id,@Param("quantity") Long quantity);

    @Query(value="{call ministry_available_quantity(:id)}",nativeQuery=true)
    public void updateAvailableStock(@Param("id") Long id);

    @Query(value="{call nearest_expiring_medicine()}",nativeQuery=true)
    public List<Ministry_Current_Stock> nearestExpiringList();

//    @Query(value="select username,email,branch,name FROM users u inner join user_roles ur on u.id=ur.user_id inner join roles r on ur.role_id=r.id;",nativeQuery=true)

    @Query(value="SELECT sum(import_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentImportStock5();


    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentImportStockYears5();

    @Query(value="SELECT sum(import_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id  order by export_date ASC limit 5;",nativeQuery=true)
    public Integer yearWiseCurrentImportStock5Avg();

    @Query(value="SELECT sum(import_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentImportStock10();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentImportStockYears10();

    @Query(value="SELECT sum(import_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC limit 10;",nativeQuery=true)
    public Integer yearWiseCurrentImportStock10Avg();

    @Query(value="SELECT sum(import_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentImportStock();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentImportStockYears();

    @Query(value="SELECT sum(import_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentImportStockAvg();

    //available
    @Query(value="SELECT sum(available_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentAvailableStock5();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentAvailableStockYears5();

    @Query(value="SELECT sum(available_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id  order by export_date ASC limit 5;",nativeQuery=true)
    public Integer yearWiseCurrentAvailableStock5Avg();

    @Query(value="SELECT sum(available_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentAvailableStock10();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentAvailableStockYears10();

    @Query(value="SELECT sum(available_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC limit 10;",nativeQuery=true)
    public Integer yearWiseCurrentAvailableStock10Avg();

    @Query(value="SELECT sum(available_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentAvailableStock();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentAvailableStockYears();

    @Query(value="SELECT sum(available_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentAvailableStockAvg();

    @Query(value="SELECT sum(supplyed_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentSuppliedStock();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentSuppliedStockYears();

    @Query(value="SELECT sum(supplyed_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentSuppliedStockAvg();

    @Query(value="SELECT sum(supplyed_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentSuppliedStock5();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentSuppliedStockYears5();

    @Query(value="SELECT sum(supplyed_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentSuppliedStockAvg5();
    @Query(value="SELECT sum(supplyed_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentSuppliedStock10();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentSuppliedStockYears10();

    @Query(value="SELECT sum(supplyed_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentSuppliedStockAvg10();

    @Query(value="SELECT sum(damage_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentDamagedStock();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC;",nativeQuery=true)
    public Integer[] yearWiseCurrentDamagedStockYears();

    @Query(value="SELECT sum(damage_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentDamagedStockAvg();

    @Query(value="SELECT sum(damage_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentDamagedStock5();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 5;",nativeQuery=true)
    public Integer[] yearWiseCurrentDamagedStockYears5();

    @Query(value="SELECT sum(damage_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentDamagedStockAvg5();
    @Query(value="SELECT sum(damage_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentDamagedStock10();

    @Query(value="SELECT year(export_date) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id group by year(export_date) order by export_date ASC limit 10;",nativeQuery=true)
    public Integer[] yearWiseCurrentDamagedStockYears10();

    @Query(value="SELECT sum(damage_quantity)/count(distinct year(export_date)) FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id order by export_date ASC;",nativeQuery=true)
    public Integer yearWiseCurrentDamagedStockAvg10();

    @Query(value="SELECT sum(import_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id where year(export_date)=year(curdate()) group by year(export_date);",nativeQuery=true)
    public Integer getCurrentImportStock();

    @Query(value="SELECT sum(available_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id where year(export_date)=year(curdate()) group by year(export_date);",nativeQuery=true)
    public Integer getCurrentAvailableStock();

    @Query(value="SELECT sum(supplyed_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id where year(export_date)=year(curdate()) group by year(export_date);",nativeQuery=true)
    public Integer getCurrentSuppliedStock();

    @Query(value="SELECT sum(damage_quantity)/1000 FROM pharmanic.ministry_current_stock cs inner join pharmanic.exported_stock es on cs.stock_id=es.stock_id where year(export_date)=year(curdate()) group by year(export_date);",nativeQuery=true)
    public Integer getCurrentDamagedStock();
}
