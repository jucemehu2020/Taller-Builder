
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.services.DishDirector;
import co.unicauca.restaurant.domain.Dish;
import java.util.Scanner;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char caracter;
        Scanner tecla = new Scanner(System.in);
        System.out.println("Desea comida Oriental o Italiana?"); 
        caracter = tecla.next().charAt(0);
        if(caracter == 'O'){
            DishDirector director = new DishDirector(new OrientalDishBuilder());
            director.create();
            Dish myDish = director.getDish();
            System.out.println("El plato le cuesta: "+ myDish.getPrice());    
        }
        if(caracter == 'I'){
            DishDirector director = new DishDirector(new ItalianDishBuilder());
            director.create();
            Dish myDish = director.getDish();
            System.out.println("El plato le cuesta: "+ myDish.getPrice()); 
        }
  } 
}
