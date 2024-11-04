package com.colak.springtutorial.mapper;

import com.colak.springtutorial.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CompanyMapperTest {

    @Autowired
    private CompanyMapper mapper;

    @Test
    void getAllCompanies() {
        List<Company> allCompanies = mapper.getAllCompanies();
        assertThat(allCompanies).isNotEmpty();
    }
}
