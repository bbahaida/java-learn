
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;
public class Main{
	public static StockInfo dummy = new StockInfo("",0.0);
	public static void main(String[] args){
		
		//List<String> data = Arrays.asList("str1","str2","str3");
		
		//data.forEach(Main::print);
		
		//use();
		
		/* List<Integer> data = Arrays.asList(1,2,54,4,4,5,2,3,8,7,3,13);
		
		System.out.println(totalValues(data));
		System.out.println(totalValues(data, e->e%2==0));
		System.out.println(totalValues(data, new Predicate<Integer>(){
			public boolean test(Integer t){
					return t % 2 != 0;
			}
		}));
		
		System.out.println(
			data.stream()
				.filter(e -> e > 3)
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.findFirst()
				.orElse(0)
		); */
		
		Timeit.code(() -> findFunctional(Tickers.symbols.parallelStream()));
	}
	
	public static void findFunctional(Stream<String> symbols){
		System.out.println(
			symbols.map(StockUtil::getPrice)
			   .filter(StockUtil.isPriceLessThan(500))
			   .reduce(dummy, StockUtil::pickHigh)
		);
	}
	
	
	
	
	public static void print(String arg){
		System.out.println(arg);
	}
	
	public static void use(){
		/*
		SeaPlane seaPlane = new SeaPlane();
		
		seaPlane.takeOff();
		seaPlane.turn();
		seaPlane.cruise();
		seaPlane.land();
		*/
	}
	
	public static int totalValues(List<Integer> numbers){
		
		return numbers.stream()
					  .map(e -> e*2)
					  .reduce(0, (acc , curr) -> acc+curr);
	}
	
	public static int totalValues(List<Integer> numbers, Predicate<Integer> selector){
		return numbers.stream()
					  .filter(selector)
					  .map(e -> e*2)
					  .reduce(0, (acc , curr) -> acc+curr);
	}
	
	
	
	
}

/*
interface Fly {
	default public void takeOff(){ System.out.println("Fly::takeOff"); }
	default public void turn(){ System.out.println("Fly::turn"); }
	default public void cruise(){ System.out.println("Fly::cruise"); }
	default public void land(){ System.out.println("Fly::land"); }
}

interface FastFly extends Fly{
	default public void takeOff(){ System.out.println("FastFly::takeOff"); }
}

interface Sail{
	default public void cruise(){ System.out.println("Sail::cruise"); }
}

class Vehicul {
	//public void cruise(){ System.out.println("Vehicul::cruise"); }
	public void land(){ System.out.println("Vehicul::land"); }
}

class SeaPlane extends Vehicul implements FastFly, Sail{
	public void cruise(){
		//System.out.println("SeaPlane::cruise"); // 1st solution
		Sail.super.cruise(); // 2nd solution or FastFly.super.cruise()
		//super.cruise(); 3rd solution iff Vehicul class has a method with the same name
	}
}

*/