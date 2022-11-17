package aula6;

import java.util.ArrayList;
import java.util.List;

public class Ementa {
	
	private String design;
	private String desc;
	private int code;
	private String startDate;
	private String endDate;
	public ArrayList<Pizza> pizzas;
	private int quant; 
	
	public Ementa(String design, String desc, int code, String startDate, String endDate, int quant) {
		this.design = design;
		this.desc = desc;
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.quant = quant;
		pizzas = new ArrayList<>();
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getQuant() {
		return pizzas.size();
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public ArrayList<Pizza> getArrayList() {
        return this.pizzas;
    }
}
