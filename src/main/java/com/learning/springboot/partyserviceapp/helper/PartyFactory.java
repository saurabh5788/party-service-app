package com.learning.springboot.partyserviceapp.helper;

import com.learning.springboot.partyserviceapp.entity.PartyEntity;

public class PartyFactory {
	public PartyEntity getNewParty(){
		return new PartyEntity();
	}
}
