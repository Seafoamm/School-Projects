
public class auxcode {
	/*
	//for each word in the list of words
	//if there is already an anagram family for it,
	//add it to the list that the anagram key is mapped to
	//else, make a new mapping to a new list
	//add the word to the list
	//and add it to the list of already defined anagrams
	//if it isn't already in the list
	for(Word word : theList)
	{
		if((AnagramFamily.myAllAnagrams.contains(word.getCanon())))
		{
			familyMap.get(word.getCanon()).add(word);
		}

		else
		{
			familyMap.put(word.getCanon(), new LinkedList<Word>());
			familyMap.get(word.getCanon()).add(word);
			if(!AnagramFamily.myAllAnagrams.contains(word.getCanon()))
			{
				AnagramFamily.myAllAnagrams.add(word.getCanon());
			}
		}
	}

	//sort each value in the map (the lists) based on 
	//the word comparator
	//then, makes an anagram family with each list and
	//add it to the anagram family list
	for(String key : familyMap.keySet())
	{
		Collections.sort(familyMap.get(key), new WordComparator());
		anagramFamilies.add(new AnagramFamily(familyMap.get(key)));
	}
	*/
}
