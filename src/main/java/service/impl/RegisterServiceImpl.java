package service.impl;

import service.RegisterService;
import dao.RegisterDao;
import dao.impl.RegisterDaoImpl;

public class RegisterServiceImpl implements RegisterService {

    private RegisterDao registerdao;

    public void setRegisterdao(RegisterDaoImpl registerDao) {
        this.registerdao = registerDao;
    }

    @Override
    public boolean register(String username, String password) {
        return registerdao.register(username, password);
    }

}