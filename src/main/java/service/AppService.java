package service;

import java.io.File;
import java.util.List;

import model.Book;
import model.Order;
import model.Orderitem;
import model.User;

/**
 * 
 * @version 1.0
 * 
 */
public interface AppService {

    /**
     * book
     * 
     */

    public Integer addBook(Book book);

    public void deleteBook(Book book);

    public void updateBook(Book book);

    public Book getBookById(int id);

    public List<Book> getAllBooks();

    /**
     * order
     * 
     */
    public Integer addOrder(Order order);

    public void deleteOrder(Order order);

    public void updateOrder(Order order);

    public Order getOrderById(int id);

    public List<Order> getAllOrders();

    public Order getOrderByStatus(int status, int id);

    public List<Order> getOrderListByUser(int uid);

    /**
     * order item
     * 
     */
    public Integer addOrderitem(Orderitem orderitem);

    public void deleteOrderitem(Orderitem orderitem);

    public void updateOrderitem(Orderitem orderitem);

    public Orderitem getOrderitemById(int id);

    public List<Orderitem> getAllOrderitems();

    public List<Orderitem> getOrderitemByOrder(int oid);

    /**
     * user
     * 
     */
    public Integer addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public User getUserById(int id);

    public List<User> getAllUsers();

    public String getIMG(String filename) throws Exception;

    public String getProfile(String filename) throws Exception;

    public void saveIMG(String filename, File file, String description) throws Exception;

    int sales(int userid, int bookid);

}
