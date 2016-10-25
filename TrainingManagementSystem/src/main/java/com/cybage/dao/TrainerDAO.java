package com.cybage.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cybage.model.Trainer;
import com.cybage.util.SessionUtil;

public class TrainerDAO {
	
	public void addTrainer(Trainer tr)
	{
		Session session=SessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		addTrainer(session,tr);
		tx.commit();
		session.close();
	}

	public Trainer getTrainerById(int id)
	{
		Trainer trainer = new Trainer();
		Session session=SessionUtil.getSession();
		 trainer =  (Trainer) session.get(Trainer.class, id);
		 return trainer;
		
	}
	
    public void addTrainer(Session session, Trainer tr){
    	Trainer trainer = new Trainer();
    	trainer.setTrainerName(tr.getTrainerName());
    	trainer.setTrainerAge(tr.getTrainerAge());
        session.save(trainer);
    }
    
    public List<Trainer> getTrainers(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from trainer");
        List<Trainer> trainers =  query.list();
        return trainers;
    }
 
   
    
    public int deleteTrainer(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String str = "delete from trainer where trainer_id = :id";
        Query query = session.createQuery(str);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateTrainer(int id, Trainer tra){
         if(id <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String str1 = "update trainer set trainer_name = :name, trainer_age=:age where trainer_id = :id";
            Query query = session.createQuery(str1);
            query.setInteger("id",id);
            query.setString("name",tra.getTrainerName());
            query.setInteger("age",tra.getTrainerAge());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}
