package springstudy.pizza.flow;

import static org.apache.log4j.Logger.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springstudy.pizza.domain.*;

import springstudy.pizza.domain.CreditCardPayment;
import springstudy.pizza.service.CustomerNotFoundException;
import springstudy.pizza.service.CustomerService;


@Component
public class PizzaFlowActions {
  private static final Logger LOGGER = getLogger(PizzaFlowActions.class);
  
   public Customer lookupCustomer(String phoneNumber)
         throws CustomerNotFoundException {
      Customer customer = customerService.lookupCustomer(phoneNumber);
      if(customer != null) {        
        return customer;
      } else {
        throw new CustomerNotFoundException();
      }
   }
   
   public void addCustomer(Customer customer) {
      LOGGER.warn("TODO: Flesh out the addCustomer() method.");
   }

   public Payment verifyPayment(PaymentDetails paymentDetails) {
     Payment payment = null;
     if(paymentDetails.getPaymentType() == PaymentType.CREDIT_CARD) {
       payment = new CreditCardPayment();
     } else {
       payment = new CashOrCheckPayment();
     }
     
     return payment;
   }
   
   public void saveOrder(Order order) {
      LOGGER.warn("TODO: Flesh out the saveOrder() method.");
   }
   
   public boolean checkDeliveryArea(String zipCode) {
     LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
     return "75075".equals(zipCode);
   }

   @Autowired
   CustomerService customerService;
}
