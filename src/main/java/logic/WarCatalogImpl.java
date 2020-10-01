package logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PokeEntityDao;
import dao.PokeEntityDaoImpl;
import dao.RankDao;
import newModel.PokemonEntity;
import test.CRUDprocess;

@Service
public class WarCatalogImpl implements WarCatalog {
	@Autowired
	private PokeEntityDao pokeEntity;
	
	public Couple couple;

	public PokemonEntity pokeEntity(String userId) {
		return pokeEntity.pokeEntity(userId);
	}
	
	public List<String> warPlay(String userId1, String userId2, RankDao rankDao){
		
		List<String> warLog = new ArrayList<String>();
		
		this.couple = new Couple(userId1,userId2);
		
		int damage, p, s, r, d, m;
		
		warLog.add("▶▶ 공격 순서를 정합니다. 스피드가 높은 쪽이 먼저 공격합니다. ◀◀");
		if(couple.red.getEntitySpeed() > couple.blue.getEntitySpeed()) {
			warLog.add("▶ " + couple.red.getPokemonName() + " (이)가 먼저 공격을 시작합니다. ◀");
		} else if(couple.red.getEntitySpeed() < couple.blue.getEntitySpeed()) {
			warLog.add("▶ " + couple.blue.getPokemonName() + " (이)가 먼저 공격을 시작합니다. ◀");
		} else {
			warLog.add("▶ 스피드가 같습니다. 먼저 공격한 Player가 선공합니다. ◀");
		}
		
		while(couple.blue.getEntityHealth() > 0 && couple.red.getEntityHealth() > 0 ) {
			
			s = (int)(Math.random()*2); String s1;
			if(s==0) {
				s1 = "앞 면";
			} else {
				s1 = "뒷 면";
			}
			warLog.add("============  동전을 던져서 << " +s1+" >> 이 나왔습니다.  ============");
			
			//공격 순서 : 스피드 비교 , 같으면 레드가 선공
			if(couple.red.getEntitySpeed() >= couple.blue.getEntitySpeed()) {// 스피드가 크거나 같으면 레드가 선공
				
				r = (int)(Math.random()*2);
				if(r == 0) {//레드 노멀 공격
					damage = couple.red.attack(couple.red.getNormalSkills().get(s), couple.blue);
					d = couple.blue.healthDecrease(couple.red.getNormalSkills().get(s), damage);
					p = couple.blue.getEntityHealth();
					
					warLog.add("■ Player의 공격 : " + couple.red.getPokemonName() + "(은)는 일반 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.red.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.blue.setEntityHealth(couple.blue.getEntityHealth()+ d); 
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!"
								);
						if(d == 0) {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다.");
					}
				} else {//레드 타입 공격
					damage = couple.red.attack(couple.red.getTypeSkills().get(s), couple.blue);
					d =couple.blue.healthDecrease(couple.red.getTypeSkills().get(s), damage);
					p = couple.blue.getEntityHealth();
					
					warLog.add("■ Player의 공격 : " + couple.red.getPokemonName() + "(은)는 특수 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.red.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.blue.setEntityHealth(couple.blue.getEntityHealth()+ d); 
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getTypeSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!");
						if(d == 0) {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다.");
					}
				}
				
				// red의 승리
				if(couple.blue.getEntityHealth() <= 0) {
					warLog.add(couple.blue.getPokemonName() + "(은)는 " + "패배했다.");
					//레드 레이팅 업, 블루 레이팅 다운
					rankDao.updatePlusRank(userId1);
					rankDao.updateMinusRank(userId2);
					break;
				}
				
				r = (int)(Math.random()*2);
				if(r == 0) {//블루 노말 공격
					damage = couple.blue.attack(couple.blue.getNormalSkills().get(s), couple.red);
					d =couple.red.healthDecrease(couple.blue.getNormalSkills().get(s), damage);
					p = couple.red.getEntityHealth();
					
					warLog.add("□ AI의 공격 : " + couple.blue.getPokemonName() + "(은)는 일반 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.blue.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.red.setEntityHealth(couple.red.getEntityHealth()+ d); 
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!");
						if(d == 0) {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다!");
					}
				} else {//블루 타입 공격
					
					damage = couple.blue.attack(couple.blue.getTypeSkills().get(s), couple.red);
					d =couple.red.healthDecrease(couple.blue.getTypeSkills().get(s), damage);
					p = couple.red.getEntityHealth();
					
					warLog.add("□ AI의 공격 : " + couple.blue.getPokemonName() + "(은)는 특수 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.blue.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.red.setEntityHealth(couple.red.getEntityHealth()+ d); 
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getTypeSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!");
						if(d == 0) {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다.");
					}
				}
				
				//blue의 승리
				if(couple.red.getEntityHealth() <= 0){
					warLog.add(couple.red.getPokemonName() + "(은)는 " + "패배했다.");
					//레드 레이팅 업, 블루 레이팅 다운
					rankDao.updatePlusRank(userId2);
					rankDao.updateMinusRank(userId1);
					break;
				}
				
			} else if (couple.red.getEntitySpeed() < couple.blue.getEntitySpeed()){//레드가 작으면 블루가 선공
				
				r = (int)(Math.random()*2);
				if(r == 0) {//블루 노말 공격
					damage = couple.blue.attack(couple.blue.getNormalSkills().get(s), couple.red);
					d =couple.red.healthDecrease(couple.blue.getNormalSkills().get(s), damage);
					p = couple.red.getEntityHealth();
					
					warLog.add("□ AI의 공격 : " + couple.blue.getPokemonName() + "(은)는 일반 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.blue.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.red.setEntityHealth(couple.red.getEntityHealth()+ d); 
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!");
						if(d == 0) {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다!");
					}
				} else {//블루 타입 공격
					
					damage = couple.blue.attack(couple.blue.getTypeSkills().get(s), couple.red);
					d =couple.red.healthDecrease(couple.blue.getTypeSkills().get(s), damage);
					p = couple.red.getEntityHealth();
					
					warLog.add("□ AI의 공격 : " + couple.blue.getPokemonName() + "(은)는 특수 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.blue.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.red.setEntityHealth(couple.red.getEntityHealth()+ d); 
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.blue.getPokemonName() + "(이)가 " + couple.blue.getTypeSkills().get(s).getSkillName() + "(으)로 " + couple.red.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!");
						if(d == 0) {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.red.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다.");
					}
				}
				//블루 승리
				if(couple.red.getEntityHealth() <= 0){
					warLog.add(couple.red.getPokemonName() + "(은)는 " + "패배했다.");
					//블루 레이팅 업, 레드 레이팅 다운
					rankDao.updatePlusRank(userId2);
					rankDao.updateMinusRank(userId1);
					break;
				}
				
				r = (int)(Math.random()*2);
				if(r == 0) {//레드 노멀 공격
					damage = couple.red.attack(couple.red.getNormalSkills().get(s), couple.blue);
					d = couple.blue.healthDecrease(couple.red.getNormalSkills().get(s), damage);
					p = couple.blue.getEntityHealth();
					
					warLog.add("■ Player의 공격 : " + couple.red.getPokemonName() + "(은)는 일반 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.red.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.blue.setEntityHealth(couple.blue.getEntityHealth()+ d); 
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!"
								);
						if(d == 0) {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다.");
					}
				} else {//레드 타입 공격
					damage = couple.red.attack(couple.red.getTypeSkills().get(s), couple.blue);
					d =couple.blue.healthDecrease(couple.red.getTypeSkills().get(s), damage);
					p = couple.blue.getEntityHealth();
					
					warLog.add("■ Player의 공격 : " + couple.red.getPokemonName() + "(은)는 특수 공격을 선택했다.");
					
					m = (int)(Math.random()*100) + 1; //난수 생성 1~100
					
					if(m > couple.red.getNormalSkills().get(s).getAccuracyRate()) {//스킬 명중률 보다 난수가 큰 경우 회피 처리
						couple.blue.setEntityHealth(couple.blue.getEntityHealth()+ d); 
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getNormalSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 공격");
						warLog.add("하지만 공격은 적중하지 않았다!" );
					} else {// 아니면 적중, 명중률이 100이면 난수가 100보다 클수가 없으므로 회피
						warLog.add(couple.red.getPokemonName() + "(이)가 " + couple.red.getTypeSkills().get(s).getSkillName() + "(으)로 " + couple.blue.getPokemonName() + "에게 " + d + "의 피해(을)를 입혔다!");
						if(d == 0) {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "아무 일도 일어나지 않았다!!!");
						} else {
							warLog.add(couple.blue.getPokemonName() + "(은)는 " + "체력이 " + p + "(이)가 되었다.");
						}
						warLog.add("사용한 공격의 횟수(이)가 " + couple.red.getNormalSkills().get(s).getSkillAttackPoint() + "(이)가 되었다.");
					}
				}
				
				//red의 승리
				if(couple.blue.getEntityHealth() <= 0) {
					warLog.add(couple.blue.getPokemonName() + "(은)는 " + "패배했다.");
					//레드 레이팅 업, 블루 레이팅 다운
					rankDao.updatePlusRank(userId1);
					rankDao.updateMinusRank(userId2);
					break;
				}
				
			} else {// 
				System.out.println("공격 순서 오류 발생");
			}
			
		}
		return warLog;
	}


}