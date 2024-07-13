package com.jbk.service;



import com.jbk.model.CategoryModel;


public interface CategoryService {

public  boolean addCategory(CategoryModel categoryModel);
	
	public CategoryModel getCategoryById(long categoryid);

	public boolean updateCategory(  CategoryModel categoryModel);
}
