package br.com.piii.service;

import br.com.piii.model.Role;
import br.com.piii.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Transactional
    public boolean save(Role role){
        try {
            roleRepository.save(role);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Role> findAll(){
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    public Role findById(int id){
        return roleRepository.findOne(id);
    }

    public boolean deleteById(int idRole){
        try{
            roleRepository.delete(idRole);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
