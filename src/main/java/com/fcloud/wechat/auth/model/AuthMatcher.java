/**
 * 
 */
package com.fcloud.wechat.auth.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.fcloud.wechat.auth.repository.ModuleAccessMappingRepository;
import com.fcloud.wechat.auth.repository.ModuleAccessRepository;

/**
 * @author ruben
 *
 */
@Component
public class AuthMatcher {
	
	private PathMatcher pathMatcher = new AntPathMatcher();
	
	@Autowired
	private ModuleAccessMappingRepository mapRepository;
	
	@Autowired
	private ModuleAccessRepository moduleRepository;
	
	private List<ModuleAccess> modulePaths;
	
	private List<ModuleAccess> getModulePaths() {
		if (modulePaths == null) {
			List<ModuleAccess> mp = new ArrayList<ModuleAccess>();
			for (ModuleAccess module : moduleRepository.findAll()) {
				mp.add(module);
			}
			Collections.sort(mp, new Comparator<ModuleAccess>() {
				@Override
				public int compare(ModuleAccess o1, ModuleAccess o2) {
					return - (o1.getPathPrefix().compareTo(o2.getPathPrefix()));
				}
			});
			modulePaths = mp;
		}
		return modulePaths;
	}

	public boolean accept(final String url, final SessionUser user) {
		List<ModuleAccessMapping> maps = mapRepository.findUserMapping(user.getUserid());
		for (final ModuleAccess path : getModulePaths()) {
			if (pathMatcher.match(path.getPathPrefix(), url)) {
				ModuleAccessMapping map = (ModuleAccessMapping) CollectionUtils.find(maps, new Predicate() {
					@Override
					public boolean evaluate(Object obj) {
						ModuleAccessMapping map = (ModuleAccessMapping) obj;
						return (path.getId().equals(map.getModule().getId()));
					}
				});
				return (map != null);
			}
		}
		return false;
	}
}
