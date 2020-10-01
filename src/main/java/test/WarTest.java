package test;

import java.util.List;

import dao.PokeEntityDao;
import dao.PokeEntityDaoImpl;
import newModel.PokemonEntity;

public class WarTest {

	public static void main(String[] args) {
		
		PokeEntityDaoImpl poke = new PokeEntityDaoImpl();
		PokemonEntity red, blue;
		
		CRUDprocess crud = new CRUDprocess(); 
		poke.setSqlSession(crud.getSession());
		
		red = poke.pokeEntity("tiger");
		blue = poke.pokeEntity("lion");
		
		red.setSqlSession(crud.getSession());
		
		red.skillSet(red.getEntityNumber());
		
		blue.setSqlSession(crud.getSession());
		
		blue.skillSet(blue.getEntityNumber());
		
		int damage, p, s, r;
		
//		while(blue.getEntityHealth() > 0 && red.getEntityHealth() > 0 ) {
//			
//			s = (int)(Math.random()*3);
//			System.out.println(s+" :랜");
//			
//			r = (int)(Math.random()*2);
//			if(r == 0) {
//				damage = red.attack(red.getNormalSkills().get(s));
//				p = blue.getEntityHealth() - damage;
//				blue.healthDecrease(damage);
//				
//				System.out.println(red.getPokemonName() + "(이)가 " + red.getNormalSkills().get(s).getSkillName() + "(으)로 " + blue.getPokemonName() + "에게 " + damage + "의 피해(을)를 입혔다."
//						+ "사용한 공격의 횟수(이)가 " + red.getNormalSkills().get(s).getSkillAttackPoint() + "되었다!");
//				System.out.println(blue.getPokemonName() + "(은)는 " + "체력이 " + p + "이 되었다.");
//				System.out.println("");
//			} else {
//				damage = red.attack(red.getTypeSkills().get(s));
//				p = blue.getEntityHealth() - damage;
//				blue.healthDecrease(damage);
//				
//				System.out.println(red.getPokemonName() + "(이)가 " + red.getTypeSkills().get(s).getSkillName() + "(으)로 " + blue.getPokemonName() + "에게 " + damage + "의 피해(을)를 입혔다."
//						+ "사용한 공격의 횟수(이)가 " + red.getNormalSkills().get(s).getSkillAttackPoint() + "되었다!");
//				System.out.println(blue.getPokemonName() + "(은)는 " + "체력이 " + p + "이 되었다.");
//				System.out.println("");
//			}
//			
//			r = (int)(Math.random()*2);
//			if(r == 0) {
//				damage = blue.attack(blue.getNormalSkills().get(s));
//				p = red.getEntityHealth() - damage;
//				red.healthDecrease(damage);
//				
//				System.out.println(blue.getPokemonName() + "(이)가 " + blue.getNormalSkills().get(s).getSkillName() + "(으)로 " + red.getPokemonName() + "에게 " + damage + "의 피해(을)를 입혔다."
//						+ "사용한 공격의 횟수(이)가 " + red.getNormalSkills().get(s).getSkillAttackPoint() + "되었다!");
//				System.out.println(red.getPokemonName() + "(은)는 " + "체력이 " + p + "이 되었다.");
//				System.out.println("");
//			} else {
//				damage = blue.attack(blue.getTypeSkills().get(s));
//				p = red.getEntityHealth() - damage;
//				red.healthDecrease(damage);
//				
//				System.out.println(blue.getPokemonName() + "(이)가 " + blue.getTypeSkills().get(s).getSkillName() + "(으)로 " + red.getPokemonName() + "에게 " + damage + "의 피해(을)를 입혔다."
//						+ "사용한 공격의 횟수(이)가 " + red.getNormalSkills().get(s).getSkillAttackPoint() + "되었다!");
//				System.out.println(red.getPokemonName() + "(은)는 " + "체력이 " + p + "이 되었다.");
//				System.out.println("");
//			}
//			
//			if(blue.getEntityHealth() <= 0) {
//				System.out.println( blue.getPokemonName() + "(은)는 " + "패배했다.");
//			} else if(red.getEntityHealth() <= 0){
//				System.out.println( red.getPokemonName() + "(은)는 " + "패배했다.");
//			}
//			
//		}

	}

}
