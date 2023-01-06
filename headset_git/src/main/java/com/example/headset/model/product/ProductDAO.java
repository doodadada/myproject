package com.example.headset.model.product;

import java.util.List;

public interface ProductDAO {
	List<ProductDTO> list();
	ProductDTO sel(String p_name);
	ProductDTO sel_code(String p_code);
}
