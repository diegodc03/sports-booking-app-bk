package com.sport.sports_reservations.booking.sports.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.sports_reservations.booking.sports.model.SportDTO;
import com.sport.sports_reservations.booking.sports.service.SportsService;
import com.sport.sports_reservations.booking.sports.mapper.SportMapper;

@Service
public class SportsServiceImpl implements SportsService {
	
			
		private SportMapper sportMapper;
		
		public SportsServiceImpl(SportMapper sportMapper) {
			super();
			this.sportMapper = sportMapper;
		}
		
		
		@Override
		public List<SportDTO> getAllSports(int cityId) {
			return this.sportMapper.findSportsByCityId(cityId);
		}
	}


