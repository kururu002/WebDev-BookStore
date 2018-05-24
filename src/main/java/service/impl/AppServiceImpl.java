package service.impl;

import java.io.File;
import java.util.List;

import model.Book;
import model.Order;
import model.Orderitem;
import model.User;
import service.AppService;
import dao.BookDao;
import dao.IMGDao;
import dao.OrderDao;
import dao.OrderitemDao;
import dao.SalesDao;
import dao.UserDao;
import dao.impl.SalesDaoImpl;

/**
 * @author seniyuting
 * @version 1.0
 * 
 */
public class AppServiceImpl implements AppService {

    private BookDao bookDao;
    private OrderDao orderDao;
    private OrderitemDao orderitemDao;
    private UserDao userDao;
    private IMGDao imgDao;
    private SalesDao salesDao;

    public void setSalesDao(SalesDaoImpl salesDao) {
        this.salesDao = salesDao;
    }

    public int sales(int userid, int bookid) {
        return salesDao.sales(userid, bookid);
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setOrderitemDao(OrderitemDao orderitemDao) {
        this.orderitemDao = orderitemDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * book
     * 
     */
    public Integer addBook(Book book) {
        return bookDao.save(book);
    }

    public void deleteBook(Book book) {
        bookDao.delete(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    /**
     * order
     * 
     */
    public Integer addOrder(Order order) {
        return orderDao.save(order);
    }

    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    public void updateOrder(Order order) {
        orderDao.update(order);
    }

    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public Order getOrderByStatus(int status, int id) {
        return orderDao.getOrderByStatus(status, id);
    }

    public List<Order> getOrderListByUser(int uid) {
        return orderDao.getOrderListByUser(uid);
    }

    /**
     * order item
     * 
     */
    public Integer addOrderitem(Orderitem orderitem) {
        return orderitemDao.save(orderitem);
    }

    public void deleteOrderitem(Orderitem orderitem) {
        orderitemDao.delete(orderitem);
    }

    public void updateOrderitem(Orderitem orderitem) {
        orderitemDao.update(orderitem);
    }

    public Orderitem getOrderitemById(int id) {
        return orderitemDao.getOrderitemById(id);
    }

    public List<Orderitem> getAllOrderitems() {
        return orderitemDao.getAllOrderitems();
    }

    public List<Orderitem> getOrderitemByOrder(int oid) {
        return orderitemDao.getOrderitemByOrder(oid);
    }

    /**
     * user
     * 
     */
    public Integer addUser(User user) {
        return userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public String getIMG(String filename) throws Exception {
        return imgDao.getIMG(filename);
    }

    public String getProfile(String filename) throws Exception {
        return imgDao.getProfile(filename);
    }

    public void saveIMG(String filename, File file, String description) throws Exception {
        imgDao.saveIMG(filename, file, description);
    }

    /**
     * @return the imgDao
     */
    public IMGDao getImgDao() {
        return imgDao;
    }

    /**
     * @param imgDao the imgDao to set
     */
    public void setImgDao(IMGDao imgDao) {
        this.imgDao = imgDao;
    }

}
