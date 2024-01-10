package com.task;

import java.util.Scanner;

enum BasePrice {
	 
	 CAR1(5000000.0), CAR2(6000000.0), CAR3(7000000.0), CAR4(8000000.0);
	private  final double value ;

	 BasePrice(double value){
		 this.value = value;
	 }
	public double getValue() {
		return value;
	}
	 

}

 enum TaxRate {

	USA(0.1) , CANADA(0.08),EUROPE(0.12),ASIA(0.05);
	
	private final double rate;

	TaxRate(double rate) {
		this.rate = rate;
	}
	public double getRate() {
		return rate;
	}
	
}
 
 abstract class Car {
	 private BasePrice basePrice;
	 private TaxRate taxRate ;
	 
	public Car(BasePrice basePrice, TaxRate taxRate) {
		super();
		this.basePrice = basePrice;
		this.taxRate = taxRate;
	}

	public BasePrice getBasePrice() {
		return basePrice;
	}
	
	public TaxRate getTaxRate() {
		return taxRate;
	}

public abstract double calculateTax();
public abstract double calculatePrice(); 

}
 
 class USACar extends Car {
public USACar(BasePrice basePrice) {
	 		super(basePrice, TaxRate.USA);
	 		
	 	}

	 @Override
	 public double calculateTax() {
			return  getBasePrice().getValue() * getTaxRate().getRate();

	 }

	 @Override
	 public double calculatePrice() {
		 	return  getBasePrice().getValue()*(1 + getTaxRate().getRate()) ;
	 
	 }

	 }
 
  class ASIACar extends Car{
		public ASIACar(BasePrice basePrice) {
			super(basePrice, TaxRate.ASIA);
			
		}

		 @Override
		 public double calculateTax() {
				return  getBasePrice().getValue() * getTaxRate().getRate();

		 }

		 @Override
		 public double calculatePrice() {
			 	return  getBasePrice().getValue()*(1 + getTaxRate().getRate()) ;
		 
		 }

	}
  
   class CANADACar extends Car{
		public CANADACar(BasePrice basePrice) {
			super(basePrice, TaxRate.CANADA);
			
		}

		 @Override
		 public double calculateTax() {
				return  getBasePrice().getValue() * getTaxRate().getRate();

		 }

		 @Override
		 public double calculatePrice() {
			 	return  getBasePrice().getValue()*(1 + getTaxRate().getRate()) ;
		 
		 }

	}
   class EUROPECar extends Car {
		public EUROPECar(BasePrice basePrice) {
			super(basePrice, TaxRate.EUROPE);
			
		}

		 @Override
		 public double calculateTax() {
				return  getBasePrice().getValue() * getTaxRate().getRate();

		 }

		 @Override
		 public double calculatePrice() {
			 	return  getBasePrice().getValue()*(1 + getTaxRate().getRate()) ;
		 
		 }

		

	}


public class CarPriceCalculator {



public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the car name(CAR1 ,CAR2 ,CAR3 ,CAR4 ) :");
        BasePrice basePrice =  BasePrice.valueOf(sc.nextLine().trim().toUpperCase());
    	System.out.println("Enter the Country name (USA ,CANADA ,EUROPE ,ASIA) :");
        String countryName = sc.nextLine().trim().toUpperCase();
        sc.close();
        
        Car car ;
       

        switch (countryName) {
            case "USA":
                car = new USACar(basePrice);
                break;
            case "CANADA":
                car = new CANADACar(basePrice);
                break;
            case "EUROPE":
            	 car = new EUROPECar(basePrice);
            	break;
            case "ASIA":
            	 car = new ASIACar(basePrice);
            	break;
            default:
                System.out.println("Invalid country name.");
                return;
        }

        double tax = car.calculateTax();
        double price = car.calculatePrice();
        
        System.out.println("Tax for the car is = "+tax);
        System.out.println("Final Price for the car is = "+price);
	}

}
