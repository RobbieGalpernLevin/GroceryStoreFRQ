import java.util.ArrayList;

public class GroceryStore
{
    /** An array of products normally stocked at the grocery store
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory)
    {
        productsStocked = initialInventory;
    }

    /** Returns an ArrayList of indices for Product elements in the
     *  productsStocked array that need to be reordered, as described in part (a)
     *  Precondition: min > 0 */
    public ArrayList<Integer> getReorderList(int min)
    {
        ArrayList <Integer> list = new ArrayList<>();
        int idx = 0;
        for(Product product : productsStocked)
        {
            if(product.getQuantity() <= min)
            {
                list.add(idx);
            }
            idx++;
        }
        return list;
    }

    /** Returns true if all products named in shoppingList are available for purchase
     *  and returns false otherwise, as described in part (b)
     *  Precondition: The products named in shoppingList are found exactly once
     *  in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList)
    {
        boolean available = true;
        for(String item : shoppingList)
        {
            boolean stocked = false;
            for(Product product : productsStocked)
            {
                if(product.getName().equals(item))
                {
                    if(product.getQuantity() >= 1)
                    {
                        stocked = true;
                    }
                }
            }
            if(!stocked)
            {
                available = false;
            }
        }
        return available;
    }

    /** Returns an ArrayList containing all Products from productStocked that
     *  have a weight that exceeds the “weight” value provided in the parameter
     */
    public ArrayList<Product> oversized(double weight)
    {
        ArrayList <Product> list = new ArrayList<>();
        int idx = 0;
        for(Product product : productsStocked)
        {
            if(product.getWeight() > weight)
            {
                list.add(product);
            }
            idx++;
        }
        return list;
    }

}