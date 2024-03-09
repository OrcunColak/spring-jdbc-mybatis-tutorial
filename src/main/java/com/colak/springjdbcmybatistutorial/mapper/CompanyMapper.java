package com.colak.springjdbcmybatistutorial.mapper;

import com.colak.springjdbcmybatistutorial.model.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Select("SELECT * FROM companies WHERE company_id = #{companyId}")
    Company getCompanyById(int companyId);

    @Select("SELECT * FROM companies")
    List<Company> getAllCompanies();

    @Insert("INSERT INTO companies (company_name, industry) VALUES (#{companyName}, #{industry})")
    void insertCompany(Company company);

    @Update("UPDATE companies SET company_name = #{companyName}, industry = #{industry} WHERE company_id = #{companyId}")
    void updateCompany(Company company);

    @Delete("DELETE FROM companies WHERE company_id = #{companyId}")
    void deleteCompany(int companyId);

    // Additional annotations for table creation and checking
    @Update("CREATE TABLE IF NOT EXISTS companies (company_id INT AUTO_INCREMENT PRIMARY KEY, company_name VARCHAR(255) NOT NULL, industry VARCHAR(255) NOT NULL)")
    void createTable();

    @Select("SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'companies'")
    int tableExists();
}

