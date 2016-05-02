package com.training.lequar.trainingfit.Controller;

import com.training.lequar.trainingfit.Model.DAO.RegisterDAO;
import com.training.lequar.trainingfit.Model.DTO.RegisterDTO;


/**
 * Created by Camilo Arias on 29/04/16.
 */

public class ControllerRegister {

    public String resultRegister(RegisterDTO rgtDTO) {
        RegisterDAO rgtDAO = new RegisterDAO();
        return rgtDAO.registrar(rgtDTO);
    }
}
