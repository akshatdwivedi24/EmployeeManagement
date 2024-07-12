package com.example.firstjobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies() , HttpStatus.OK) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id , @RequestBody Company company){
        companyService.updateCompany(company , id);
        return new ResponseEntity<>("Company Updated Successfully" , HttpStatus.OK);
    }

    public ResponseEntity<String> addCompany(@RequestBody Company company){

        companyService.createCompany(company);
        return new ResponseEntity<>("New Company Added" , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){

        Boolean b = companyService.deleteCompany(id);
        if(b){
            return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found" , HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(Long id , Company company){
        Company c = companyService.getCompanyById(id);
            if(c!= null) {
                return new ResponseEntity<>(company, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

