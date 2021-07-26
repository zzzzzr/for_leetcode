package cxymsjd;

import java.util.*;
class AnimalNode {
	int animalId;
	int animalType;
	AnimalNode pre;
	AnimalNode nxt;

	public AnimalNode() {
	}

	public AnimalNode(int animalId, int animalType) {
		this.animalId = animalId;
		this.animalType = animalType;
	}
}

class AnimalShelf {
	AnimalNode anyAnimalStart;
	AnimalNode anyAnimalEnd;
	Deque<AnimalNode> catList;
	Deque<AnimalNode> dogList;

	public AnimalShelf() {
		anyAnimalStart = new AnimalNode();
		anyAnimalEnd = new AnimalNode();
		anyAnimalStart.nxt = anyAnimalEnd;
		anyAnimalEnd.pre = anyAnimalStart;

		catList = new LinkedList<>();
		dogList = new LinkedList<>();
	}

	public void enqueue(int[] animal) {
		AnimalNode tempAnimal = new AnimalNode(animal[0], animal[1]);
		AnimalNode preNode = anyAnimalEnd.pre;

		preNode.nxt = tempAnimal;
		tempAnimal.nxt = anyAnimalEnd;
		anyAnimalEnd.pre = tempAnimal;
		tempAnimal.pre = preNode;

		if(animal[1]==0){
			catList.addLast(tempAnimal);
		} else if (animal[1]==1){
			dogList.addLast(tempAnimal);
		}

	}

	public int[] dequeueAny() {

		AnimalNode tempAnimal = anyAnimalStart.nxt;
		if (tempAnimal == anyAnimalEnd){
			return new int[]{-1, -1};
		}
		AnimalNode nxtNode = tempAnimal.nxt;
		anyAnimalStart.nxt = nxtNode;
		nxtNode.pre = anyAnimalStart;

		int []ans = new int[2];
		ans[0] = tempAnimal.animalId;
		ans[1] = tempAnimal.animalType;
		if (ans[1]==0){
			catList.pollFirst();
		} else if (ans[1]==1){
			dogList.pollFirst();
		}
		return ans;
	}

	public int[] dequeueDog() {
		if (dogList.isEmpty()){
			return new int[]{-1, -1};
		}
		AnimalNode tempAnimal = dogList.pollFirst();

		int []ans = new int[2];
		ans[0] = tempAnimal.animalId;
		ans[1] = tempAnimal.animalType;

		AnimalNode preNode = tempAnimal.pre;
		AnimalNode nxtNode = tempAnimal.nxt;
		preNode.nxt = nxtNode;
		nxtNode.pre = preNode;

		return ans;
	}

	public int[] dequeueCat() {
		if (catList.isEmpty()){
			return new int[]{-1, -1};
		}
		AnimalNode tempAnimal = catList.pollFirst();

		int []ans = new int[2];
		ans[0] = tempAnimal.animalId;
		ans[1] = tempAnimal.animalType;

		AnimalNode preNode = tempAnimal.pre;
		AnimalNode nxtNode = tempAnimal.nxt;
		preNode.nxt = nxtNode;
		nxtNode.pre = preNode;

		return ans;
	}
}

class AnimalShelf2 {
	Deque<int[]> catList;
	Deque<int[]> dogList;

	public AnimalShelf2() {
		catList = new LinkedList<>();
		dogList = new LinkedList<>();
	}

	public void enqueue(int[] animal) {
		if (animal[1]==0){
			catList.addLast(animal);
		} else {
			dogList.addLast(animal);
		}
	}

	public int[] dequeueAny() {
		if (catList.isEmpty()){
			if (dogList.isEmpty()){
				return new int[]{-1,-1};
			} else {
				return dogList.pollFirst();
			}
		}
		if (dogList.isEmpty()){
			return new int[]{-1,-1};
		}
		if (catList.peek()[0]<dogList.peek()[0]){
			return catList.pollFirst();
		} else {
			return dogList.pollFirst();
		}
	}

	public int[] dequeueDog() {
		if (dogList.isEmpty()){
			return new int[]{-1,-1};
		}
		return dogList.pollFirst();
	}

	public int[] dequeueCat() {
		if (catList.isEmpty()){
			return new int[]{-1,-1};
		}
		return catList.pollFirst();
	}
}

public class mst0306 {
}
