import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;


public class mainAdmin {
	
	public static void main(String[] args) {
		ArrayList<Stall> stallList = new ArrayList<Stall>();
		ArrayList<IngredientOrder> ingredientList = new ArrayList<IngredientOrder>();
		ArrayList<Food> foodList = new ArrayList<Food>();
		ArrayList<Promotion> promotionlist = new ArrayList<Promotion>();
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		
		//	Stall	 (int id, String name, LocalDate startOperatingDate, LocalTime operatingTime, String operatorStall)
		stallList.add(new Stall(001, "Japanese Food Stall", LocalDate.of(2020, 1, 8),  LocalTime.of(10,43,12), "Mr.Lee"));
		stallList.add(new Stall(002, "Chinese Food Stall", LocalDate.of(2020, 1, 8),  LocalTime.of(10,43,12), "Mr.Wee"));
		stallList.add(new Stall(003, "Indian Food Stall", LocalDate.of(2020, 1, 8),  LocalTime.of(10,43,12), "Mr.Kee"));
		stallList.add(new Stall(004, "Malay Food Stall", LocalDate.of(2020, 1, 8),  LocalTime.of(10,43,12), "Mr.Tee"));
		stallList.add(new Stall(005, "Thai Food Stall", LocalDate.of(2020, 1, 8),  LocalTime.of(10,43,12), "Mr.Yee"));
		
		//	Food	 (int id, String name, int price, boolean isPromotion, int promotionPrice, Date promotionDate) 
		foodList.add(new Food(001, "Salmon Sushi", 9, false, 6, LocalDate.of(2020, 1, 8)));
		foodList.add(new Food(002, "Bak Kut Teh", 9, true, 6, LocalDate.of(2020, 1, 8)));
		foodList.add(new Food(003, "Roti Plata", 9, false, 6, LocalDate.of(2020, 1, 8)));
		foodList.add(new Food(004, "Nasi Lemak", 9, true, 6, LocalDate.of(2020, 1, 8)));
		foodList.add(new Food(005, "Tomyam", 9, false, 6, LocalDate.of(2020, 1, 8)));

		//	IngredientOrder(int id, String ingredientName, boolean orderStatus) 
		ingredientList.add(new IngredientOrder(001, "Rice", false));
		ingredientList.add(new IngredientOrder(002, "Fish", true));
		ingredientList.add(new IngredientOrder(003, "Peanut", false));
		ingredientList.add(new IngredientOrder(004, "Flour", true));
		ingredientList.add(new IngredientOrder(005, "Prawn", true));
		
		//Payment	(int id, String custName, String method, Food foodpurchased, int total)
		paymentList.add(new Payment(001, "Mr. Lol", "cash", "Salmon Sushi", 9, LocalDate.of(2020, 1, 8)));
		paymentList.add(new Payment(002, "Mr. Li", "NETS", "Bak Kut Teh", 6, LocalDate.of(2020, 1, 8)));
		paymentList.add(new Payment(003, "Mr. Po", "PayWay", "Roti Plata", 9, LocalDate.of(2020, 1, 8)));
		paymentList.add(new Payment(004, "Mr. Op", "PayNow", "Tomyam", 6, LocalDate.of(2020, 1, 8)));
		paymentList.add(new Payment(005, "Mr. Liq", "PayNow", "Nasi Lemak", 9, LocalDate.of(2020, 1, 8)));
		
		mainAdmin ma = new mainAdmin();
		
		//Daren Testing
		//ma.doManageStall(stallList);
		//ma.doViewIngredientRequestOrder(ingredientList);
		ma.doGenerateSalesReport(paymentList);
		
		ingredientList.add(new IngredientOrder(004, "Flour", false));
		ingredientList.add(new IngredientOrder(005, "Prawn", false));
		
		Date promoDate1 = null; 
		Date promoDate2 = null;
		Date promoDate3 = null;
		//just initialising as null
		try {
			promoDate3 = new SimpleDateFormat("dd/MM/yyyy").parse("8/6/2020");
			promoDate1=new SimpleDateFormat("dd/MM/yyyy").parse("8/10/2020");
			promoDate2=new SimpleDateFormat("dd/MM/yyyy").parse("8/12/2020");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		promotionlist.add(new Promotion(002, 6, promoDate1));
		promotionlist.add(new Promotion(003, 6, promoDate2));
		promotionlist.add(new Promotion(001, 6, promoDate3));
		
		
	}

	private void displayMenu() {
		System.out.println("Manage Stall"); //Daren do this
		System.out.println("Manage Food Item");
		System.out.println("View Promotion Offer");
		System.out.println("View Ingredient Request Order"); //Daren do this
		System.out.println("Purchase Ingredient Online");
		System.out.println("Generate Sales Report"); //Daren do this
	}
	
	private void displayEditStallMenu() {
		Helper.line(40, "-");
		System.out.println("**Edit Stall Menu**");
		Helper.line(40, "-");
		System.out.println("1. View Stall");
		System.out.println("2. Add Stall");
		System.out.println("3. Remove Stall");
		System.out.println("4. Update Stall");
	}
	
	private void displayEditFoodItemMenu() {
		System.out.println("1. View FoodItem");
		System.out.println("2. Add FoodItem");
		System.out.println("3. Remove FoodItem");
		System.out.println("4. Change FoodItem");
	}
	
	private void doManageStall(ArrayList<Stall> stallList) {
		int option = 0;
		
		while (option != 5) {
			displayEditStallMenu();
			option = Helper.readInt("Enter option > ");
			if (option == 1) {
				String output = String.format("%-5s %-20s %-25s %-15s %-20s\n", "ID", "NAME", "START OPERATION DATE", "OPERATING TIME", "STALL OPERATOR");
				
				for (Stall s : stallList) {
					output += String.format("%-5s %-20s %-25s %-15s %-20s\n", s.getId(), s.getName(), s.getStartOperatingDate(), s.getOperatingTime(), s.getOperatorStall());
				}
				System.out.println(output);
			}
			else if(option == 2) {
				System.out.println("**ADD STALL**");
				int id = Helper.readInt("Enter Stall ID > ");
				String name = Helper.readString("Enter Stall Name > ");
				LocalDate startOperatingDate = LocalDate.of(2020, 1, 8);
				LocalTime operatingTime = LocalTime.of(10,43,12);
				String operatorStall = Helper.readString("Enter Stall Operator > ");
				
				stallList.add(new Stall(id, name, startOperatingDate, operatingTime, operatorStall));
			}
			else if(option == 3) {
				System.out.println("**REMOVE STALL**");
				int id = Helper.readInt("Enter Stall ID > ");
				
				boolean found = false;
				
				for (Stall s : stallList) {
					if(s.getId() == id) {
						stallList.remove(s);
						found = true;
						System.out.println("Stall Removed");
						break;
					}
				}
				if (found == false) {
					System.out.println("Stall Not Found");
				}
			}
			else if(option == 4) {
				System.out.println("**UPDATE STALL**");
				int id = Helper.readInt("Enter Stall ID > ");
				
				boolean found = false;
				
				for (Stall s : stallList) {
					if(s.getId() == id) {
						id = Helper.readInt("Enter new Stall ID > ");
						String name = Helper.readString("Enter new Stall Name > ");
						String operatorStall = Helper.readString("Enter new Stall Operator > ");
						
						s.setName(name);
						s.setOperatorStall(operatorStall);
						found = true;
						System.out.println("Stall Updated");
						break;
					}
				}
				if (found == false) {
					System.out.println("Stall Not Found");
				}
			}
		}
	}
	
	private void doManageFoodItem(ArrayList<Food> foodList) {
		  
		int option = 0;
		while (option != 5) {
			displayEditFoodItemMenu();
			option = Helper.readInt("Enter an option > ");
	      
			if (option == 1) {
				Helper.line(40, "=");
				System.out.println("FOOD LIST");
				Helper.line(40, "=");
				
				String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ID", "Name",
						"Price", "Is Promotion","Promotion Price", "Promotion Date");

			    for (int i = 0; i < foodList.size(); i++) {

			    	output += String.format("%-10s %-30s %-10s %-10s %-20d\n", foodList.get(i).getId(),
			    			foodList.get(i).getName(), foodList.get(i).getPrice(),
			    			foodList.get(i).isPromotion(),
			    			foodList.get(i).getPromotionPrice(),foodList.get(i).getPromotionDate());
			    }
			    	
			    System.out.println(output);
			    
			}else if (option == 2) {
				int ID = Helper.readInt("Enter ID > ");
				String name = Helper.readString("Enter name > ");
				int price = Helper.readInt("Enter Price > ");
				boolean isAvailable = false;
				int promotionPrice = Helper.readInt("Enter Promotion Price > ");
				LocalDate promotionDate = LocalDate.of(2020, 1, 8);
				
				foodList.add(new Food(ID, name, price, isAvailable, promotionPrice, promotionDate));
				Helper.line(40, "=");
				System.out.println("Food item added");
				Helper.line(40, "=");
			}else if (option == 3) {
		        System.out.println("");
		        Helper.line(40, "-");
		        System.out.println("Remove Food Item");
		        Helper.line(40, "-");
		        System.out.println("");
		        int ID = Helper.readInt("Enter ID of the item you want to remove > ");
		        
		        boolean present = false;
		        
		        for (Food  f: foodList) {
		          if (f.getId() == ID) {
		            foodList.remove(f);
		            present = true;
		            break;
		          }      
		        }
		        if (present == false) {
		          System.out.println("Food item not found");
		        }
				Helper.line(40, "=");
				System.out.println("Food item Deleted!");
				Helper.line(40, "=");
	        
			}else if (option == 4) {
		        System.out.println("Update Food Item");
	            int id = Helper.readInt("Enter Food Item ID > ");
	            
	            boolean present1 = false;
	            
	            for (Food f : foodList) {
	              if(f.getId() == id) {
	                String name = Helper.readString("Enter new Food Item Name > ");
	                int price = Helper.readInt("Enter new Food Item price > ");
	                int promotionPrice = Helper.readInt("Enter new Promotion Price > ");
	                
	                f.setName(name);
	                f.setPrice(price);
	                f.setPromotionPrice(promotionPrice);
	                present1 = true;
	                break;
	              }
	            }
	            if (present1 == false) {
	              System.out.println("Food Item Found");
	            }
				Helper.line(40, "=");
				System.out.println("Food item Updated!");
				Helper.line(40, "=");
			}
		}
	}
	
	private void doViewPromotionOffer(ArrayList<Promotion> promotionList) {
		//view promotion offers
		Helper.line(40, "-");
		System.out.println("VIEW PROMOTION OFFER");
		Helper.line(40, "-");
		
		String output = String.format("%-10s %-18s %-20s\n", "ID", "PROMOTION PRICE", "PROMOTION DATE");

		for(Promotion p : promotionList) {
			output += String.format("%-10d %-18s %-20s\n", p.getId(), p.getPromotionPrice(), p.getPromotionDate());
		}
		System.out.println(output);
	}
	
	private void doViewIngredientRequestOrder(ArrayList<IngredientOrder> ingredientList) {
		Helper.line(40, "-");
		System.out.println("**View Ingredient Request Order**");
		Helper.line(40, "-");
		
		String output = String.format("%-7s %-15s %-20s\n", "ID", "INGREDIENT", "ORDER STATUS");

		for(IngredientOrder io : ingredientList) {
			output += String.format("%-7d %-15s %-20s\n", io.getId(), io.getIngredientName(), io.isOrderStatus()?"Ordered":"Havent Order");
		}
		System.out.println(output);
	}
	
	private void doPurchaseIngredientOnline(ArrayList<IngredientOrder> ingredientList) {
		Helper.line(40, "-");
		System.out.println("**Purchase Ingredients Online**");
		Helper.line(40, "-");
		
		int ID = Helper.readInt("Enter ID > ");
		String ingredientName = Helper.readString("Enter name > ");
		boolean isOrderStatus = true;
		
		ingredientList.add(new IngredientOrder(ID, ingredientName, isOrderStatus));
		Helper.line(40, "=");
		System.out.println("Ingredients Purchased Online");
		Helper.line(40, "=");
	}
	
	private void doGenerateSalesReport(ArrayList<Payment> paymentList) {
		Helper.line(40, "-"); 
		System.out.println("**Sales Report**"); 
		Helper.line(40, "-");
		
		int rptType = Helper.readInt("1. Daily\n2. Monthly\nEnter report type to generate > ");
		
		int revenue = 0;
		
		int month = 0;
		int day = 0;
		
		String output = String.format("%-7s %-15s %-15s %-15s %-10s %-10s\n", "ID", "CUSTOMER NAME", "PAYMENT METHOD", "FOOD PURCHASED", "TOTAL", "PAYMENT DATE");
		month = Helper.readInt("Enter Month to view > ");
		
		if (rptType == 1) {
			day = Helper.readInt("Enter Date to view > ");
		}
		for(Payment p : paymentList) {
			if (rptType == 2) {
				if(p.getPayDate().getMonthValue() == month){
					output += String.format("%-7s %-15s %-15s %-15s %-10s %-10s\n", p.getId(), p.getCustName(), p.getMethod(), p.getFoodpurchased(), p.getTotal(), p.getPayDate());
					revenue += p.getTotal();
				}
			}
			else if (rptType == 1) {
				if(p.getPayDate().getMonthValue() == month && p.getPayDate().getDayOfMonth() == day){
					output += String.format("%-7s %-15s %-15s %-15s %-10s %-10s\n", p.getId(), p.getCustName(), p.getMethod(), p.getFoodpurchased(), p.getTotal(), p.getPayDate());
					revenue += p.getTotal();
				}
			}
		}
		
		System.out.println(output);
		System.out.println("Total revenue generated is > " + revenue);
	}

public static void AddFoodItem(ArrayList<Food> foodList, Food f) {
	foodList.add(f);
}
public static void setHeader(String header) {
	Helper.line(80, "-");
	System.out.println(header);
	Helper.line(80, "-");
}


public static String retrieveAllFoodItem(ArrayList<Food> foodList) {
	// TODO Auto-generated method stub
	String output = "";
	for (int i = 0; i < foodList.size(); i++) {

	    	output += String.format("%-10s %-30s %-10s %-10s %-20d\n", foodList.get(i).getId(),
	    			foodList.get(i).getName(), foodList.get(i).getPrice(),
	    			foodList.get(i).isPromotion(),
	    			foodList.get(i).getPromotionPrice(),foodList.get(i).getPromotionDate());
	    }
	return output;
}
public static void viewAllFoodItem(ArrayList<Food> foodList) {
	mainAdmin.setHeader("FOOD LIST");
	String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s\n", "ID", "Name",
			"Price", "Promotion status","Promotion Price", "Promotion Date");
	 output += retrieveAllFoodItem(foodList);	
	System.out.println(output);
}
public static boolean DeleteFoodItem(ArrayList<Food> foodList, String name) {
	
	boolean isDeleted= false;

	for (int i = 0; i < foodList.size(); i++) {
		if (name.equalsIgnoreCase(foodList.get(i).getName())) {
			isDeleted = true;				
		}
	}
	return isDeleted;
}
public static void DeletedFoodItem(ArrayList<Food> foodList) {
	mainAdmin.retrieveAllFoodItem(foodList);
	String name = Helper.readString("Enter Food Name > ");
	Boolean isDeleted = DeleteFoodItem(foodList, name);
	if (isDeleted == false) {
		System.out.println("Invalid Food Name");
	} else {
		System.out.println("Food " + name + " is Removed");
	}
}
public static boolean doUpdateFoodItem(ArrayList<Food> foodList, String name) {
	boolean isUpdated = false;

	for (int i = 0; i < foodList.size(); i++) {
		if (name.equalsIgnoreCase(foodList.get(i).getName())){
			isUpdated = true;	
		}
	}
	return isUpdated;
	
}
public static void UpdateFoodItem(ArrayList<Food> foodList) {
	mainAdmin.retrieveAllFoodItem(foodList);
	String Name = Helper.readString("Enter Name > ");
	Boolean isUpdated = doUpdateFoodItem(foodList, Name);
	
	if (isUpdated == false) {
		System.out.println("Invalid Name");
	} else {
		System.out.println("Food " + Name + " Updated");
	}
}
}

