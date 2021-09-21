package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio con Array
 *
 * @author Luis Arango, Javier Duran
 */
public class FoodJsonArrayRepository implements IFoodJsonRepository{
    private static List<Food> datos;
    
    public FoodJsonArrayRepository(){
        if (datos==null) {
            datos=new ArrayList<>();
            inicializar();
        }
    }
    private void inicializar(){
        datos.add(new CryptFood(1, "Arroz", FoodTypeEnum.ENTRADA));
        datos.add(new CryptFood(2, "Frijoles", FoodTypeEnum.PRINCIPIO));
        datos.add(new CryptFood(3, "Lomo de Cerdo", FoodTypeEnum.CARNE));
        datos.add(new CryptFood(4, "Jugo de Mango", FoodTypeEnum.JUGO));
    }
    @Override
    public Food getById(int id) {
        for (Food dato : datos) {
            if (dato.getId()==id) {
                return dato;
            }
        }
        return null;
    }

    @Override
    public List<String> foods() {
        List<String> list=new ArrayList<>();
        for (Food dato : datos) {
            list.add(dato.getId()+","+dato.getName()+","+dato.getType());
        }
        return list;
    }

    @Override
    public boolean add(Food food) {
        for (Food dato : datos) {
            if (dato.equals(food)) {
                return false;
            }
        }
        datos.add(food);
        return true;
    }

    @Override
    public void remove(int id) {
        for (Food dato : datos) {
            if (dato.getId()==id) {
                datos.remove(dato);
                break;
            }
        }
    }

    @Override
    public boolean modify(Food food) {
       
        for (Food dato : datos) {
            if (dato.getId()==food.getId()) {
                datos.remove(dato);
                datos.add(food);
                return true;
            }
        }
        return false;
    }
}
