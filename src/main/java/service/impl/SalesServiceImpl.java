package service.impl;

import dao.SalesDao;
import dao.impl.SalesDaoImpl;

public class SalesServiceImpl implements service.SalesService {

    private SalesDao salesdao;

    public void setSalesdao(SalesDaoImpl salesDao) {
        this.salesdao = salesDao;
    }

    @Override
    public int sales(int userid, int bookid) {
        return salesdao.sales(userid, bookid);
    }

}