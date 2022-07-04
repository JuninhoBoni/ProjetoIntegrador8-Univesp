package br.com.piii.service;

import br.com.piii.model.Advertising;
import br.com.piii.repository.AdvertisingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertisingService {

    @Autowired
    private AdvertisingRepository advertisingRepository;
    @Transactional
    public boolean save(Advertising advertising){
        try {
            advertisingRepository.save(advertising);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Advertising> findAll(){
        return advertisingRepository.findAll();
    }

    public Advertising findById(int advertisingId){
        return advertisingRepository.findOne(advertisingId);
    }

    public boolean deleteById(int idAdvertisingRepository){
        try{
            advertisingRepository.delete(idAdvertisingRepository);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
