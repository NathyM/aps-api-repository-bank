package br.unit.api;

import br.unit.domain.client.Account;
import br.unit.domain.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    AccountRepository accountRepository;

    @PostMapping("/cadastroCliente")
    public ResponseEntity<Object> cadastroConta(){
        try{
            Account acc = new Account();
            Account account = accountRepository.save(acc);
            HttpStatus httpStatus = HttpStatus.ACCEPTED;
            return ResponseEntity.status(httpStatus).body(account);
            }catch (Exception e){
            e.printStackTrace();
            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(httpStatus).body(false);
        }
    }

    @GetMapping("/saldo/{numeroConta}")
    public ResponseEntity<Object> saldo(@PathVariable("numeroConta") String numeroConta){
        try{
            Double numeroContaD = Double.parseDouble(numeroConta);
            Account account = accountRepository.getOne(numeroContaD);
            HttpStatus httpStatus = HttpStatus.ACCEPTED;
            return ResponseEntity.status(httpStatus).body(account.getSaldoConta());
        } catch (Exception e){
            e.printStackTrace();
             HttpStatus httpStatus= HttpStatus.BAD_REQUEST;
             return ResponseEntity.status(httpStatus).body(false);
        }
    }
    @PutMapping("/deposito/{numeroConta}")
    public ResponseEntity<Object> deposito(@PathVariable ("numeroConta") Double numeroConta, @RequestBody Double valor ){
        try{
            Account account = accountRepository.getOne(numeroConta);
            account.deposito(valor);
            Account saldoAdd = accountRepository.save(account);
            HttpStatus httpStatus = HttpStatus.ACCEPTED;
            return ResponseEntity.status(httpStatus).body(saldoAdd);
        }catch (Exception e){
            e.printStackTrace();
            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(httpStatus).body(false);
        }
    }
    @PutMapping("/saque/{numeroConta}")
    public ResponseEntity<Object> saque(@PathVariable ("numeroConta") Double numeroConta, @RequestBody Double valor){
        try {
            Account account = accountRepository.getOne(numeroConta);
            account.saque(valor);
            Account accountLess = accountRepository.save(account);
            HttpStatus httpStatus = HttpStatus.ACCEPTED;
            return ResponseEntity.status(httpStatus).body(accountLess);
        }catch( Exception e){
            e.printStackTrace();
            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(httpStatus).body(false);

        }
    }




}
