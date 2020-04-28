package com.ryanfleming.astardonia;

import java.util.Random; 

public class NameGenerator {
	char[] alphabetC = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	char[] alphabetL = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public String planet() {
		String planet;
		String[] planetNames = {"earth", "mercury", "venus", "mars", "eros", "gaspra", "ida", "eos", "kalliope", "mathilde", "jupiter", "amalthea", "saturn", "europa", "mercury", "helene", "atlas", "tarvos", "mundilfari", "skathi", "bazeg", "ibelas", "badera", "zalispa", "ziopa", "poliera", "skathi", "daphnis", "aegir", "bestla", "hati", "loge", "greip", "cordelia", "zeus", "zopilasa", "iopetes", "bianca", "eris", "hamaka", "haumea", "styx", "belinda", "julliet", "methone", "kleyna", "polydeuces", "fenrir", "samathe", "perdita", "mab", "cupid", "alderon", "hoth"};
		planet = stringBuilder(planetNames);
		return planet;
	}
	
	public String solarSystem() {
		String solarSystem;
		String[] solarSystemNames = {};
		solarSystem = stringBuilder(solarSystemNames);
		return solarSystem;
	}
	
	public String galaxy() {
		String galaxy;
		String[] galaxyNames = {"milky", "andromeda", "messier", "whirlpool", "sombrero"};
		galaxy = stringBuilder(galaxyNames);
		return galaxy;
	}
	
	public String universe() {
		String universe;
		String[] universeNames = {};
		universe = stringBuilder(universeNames);
		return universe;
	}
	
	public String stringBuilder(String[] names) {
		int i = names.length;
		Random rand = new Random();
		int[][] letters = new int[26][26];
		int[] namesLengths = new int[i];
		int[] letterSum = new int[26];
		String name = "";
		int[] startLetters = new int[26];
		
		for(int x = 0; x < i; x++) { //number` of times each letter comes after a certain letter
			startLetters[(names[x].charAt(0) - 97)]++;
		}
		
		for(int x = 0; x < i; x++) { //number of times each letter comes after a certain letter
			for(int y = 1; y < names[x].length(); y++) {
				letters[names[x].charAt(y-1)-97][names[x].charAt(y)-97] += 1;
			}
		}
		
		for(int x = 0; x < i; x++) { //store each name length into an equally sized array
			namesLengths[x] = names[x].length();
		}
		
		for(int x = 0; x < letters.length; x++) {// calculate the number of letter occurrences after each letter
			int sum = 0;
			for(int y = 0; y < letters.length; y++) {
				sum += letters[x][y];
				letters[x][y] = sum;
			}
			letterSum[x] = sum;
		}
		
		int length = namesLengths[rand.nextInt(i)];
		char startLetter = (char)(rand.nextInt(26) + 97);
		boolean tr = false;
		
		while(tr == false) {
			if(startLetters[startLetter - 97] == 0) {
				startLetter = (char)(rand.nextInt(26) + 97);
			}else {
				tr = true;
			}
		}
		
		char nextLetter = ' ';
		
		for(int x = 0; x < length; x++) {
			if(startLetter == '{') {
				name += "\'";
			}else {
				name += startLetter;
			}
			int newL;
			int val = 1;
			val = letterSum[startLetter - 97];
			if(val == 0) {
				newL = 0;
			}else {
				newL = rand.nextInt(val);
			}
			
			for(int y = 0; y < letters.length; y++) {
				if(newL == 0 && newL <= letters[startLetter-97][y]) {
					nextLetter = (char)(y+97);	
					startLetter = nextLetter;
				}else if(y > 0 && newL >= letters[startLetter-97][y-1] && newL <= letters[startLetter-97][y] ) {
					nextLetter = (char)(y+97);
					startLetter = nextLetter;
					break;
				}
			}
		}
		return name;
	}
	
}
