package com.dvsuperior.hrpayroll.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsuperior.hrpayroll.entities.Payment;
import com.dvsuperior.hrpayroll.entities.Worker;
import com.dvsuperior.hrpayroll.feignClients.WorkerFeignClient;

@Service
public class PaymentService {
	
//	@Value("${hr-worker.host}")
//	private String workerHost;
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
    public Payment getPayment(Long workerId,int days) {
//		Map<String, String> uriVariable = new HashMap<>();
//		uriVariable.put("id", workerId.toString());
//		Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}",Worker.class, uriVariable);
    	
    	Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
	}
}

