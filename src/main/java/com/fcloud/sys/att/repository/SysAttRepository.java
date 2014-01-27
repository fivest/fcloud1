package com.fcloud.sys.att.repository;

import java.io.File;

import org.springframework.stereotype.Repository;

import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.sys.att.model.SysAtt;
@Repository
public class SysAttRepository extends SimpleRepository<SysAtt>{

	public void deleteByAttId(String attId) throws Exception{
		SysAtt sysAtt = findOne(attId);
		if(sysAtt != null){
			String delPath = sysAtt.getFileUrl();
			File delFiele = new File(delPath);
			if (delFiele.isFile() && delFiele.exists()) {  
				delFiele.delete();  
		    }  
		}
		delete(sysAtt);
	}
}
