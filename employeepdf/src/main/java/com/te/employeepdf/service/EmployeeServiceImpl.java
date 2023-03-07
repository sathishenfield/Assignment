package com.te.employeepdf.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.te.employeepdf.entity.Employee;
import com.te.employeepdf.repository.EmployeeDAO;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee registerEmployee(Employee employee) {
		
		return dao.save(employee);
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
		List<Employee> findAll = dao.findAll();
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		
		PdfPTable table=new PdfPTable(3);
		PdfPCell c1=new PdfPCell(new Phrase("ID"));
		table.addCell(c1);
		
		c1=new PdfPCell(new Phrase("Name"));
		table.addCell(c1);
		
		c1=new PdfPCell(new Phrase("Age"));
		table.addCell(c1);
		table.setHeaderRows(1);
		
		  findAll.stream().forEach(employee->{
			  table.addCell(employee.getId().toString());
			  table.addCell(employee.getName());
			  table.addCell(employee.getAge().toString());
		  });
		
		
		
		
		document.add(table);
	
		document.close();
	}

	@Override
	public Employee searchEmployee(Integer id) {
		Optional<Employee> findById = dao.findById(id);
		Employee employee=null;
		if (findById.isPresent()) {
			employee=findById.get();
		}
		return employee;
	}
	
public void exportSearch(HttpServletResponse response,Integer id) throws DocumentException, IOException {
		
        Optional<Employee> findById = dao.findById(id);
        Employee employee = findById.get();
        
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		PdfPTable table=new PdfPTable(3);
		PdfPCell c1=new PdfPCell(new Phrase("ID"));
		table.addCell(c1);
		
		c1=new PdfPCell(new Phrase("Name"));
		table.addCell(c1);
		
		c1=new PdfPCell(new Phrase("Age"));
		table.addCell(c1);
		table.setHeaderRows(1);
		
		table.addCell(employee.getId().toString());
		table.addCell(employee.getName());
		table.addCell(employee.getAge().toString());
		document.add(table);
	
		document.close();
	}



}
