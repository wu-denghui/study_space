/**
 * 
 */
package com.goodhealth.web.dao;

import com.goodhealth.web.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月2日
 * @Description
 */
public interface DrugRepository  extends JpaRepository<Drug, Integer>,
JpaSpecificationExecutor<Drug> {

      Drug   findByDrugName(String name);

      List<Drug>    findByDrugNameEndingWith(String name);

      @Modifying
      @Query(value="update  drug  set  drug_price= ?  WHERE  drug_id=?",nativeQuery=true)
       void     updateDrugPriceById(BigDecimal newPrice, int id);
}
