package com.anhduc.managecake.reponsitory;

import com.anhduc.managecake.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutReponsitory extends JpaRepository<Checkout, Long>  {


}
