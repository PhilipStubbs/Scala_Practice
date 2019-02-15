package lectures.part3fp

object TuplesAndMaps extends App {

	val aTuple = (2, "hello")

	//	println(aTuple._2)
	//	println(aTuple.copy(_2 = "test"))
	//	println((aTuple.swap))

	val aMap: Map[String, Int] = Map()


	val phonebook = Map(("Mike", 555), "IKE" -> 453).withDefaultValue(-1)


	//	println(phonebook.contains("Mike"))
	//	println(phonebook("Mike"))

	val newPairing = "Mary" -> 678
	val newPhonebook = phonebook + newPairing

	//	println(newPhonebook)


	//	println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))
	//
	//	println(phonebook.filterKeys(_.startsWith("M")))
	//
	//	println(phonebook.mapValues(number => number * 10))
	//
	//	println(phonebook.toList)
	//	println(List(("James", 555)).toMap)

	//	val sn = new SocialNetwork
	//	sn("philip")
	//	sn("james")
	//	sn.printUsers
	//	sn.addFriend("philip", "mike")
	//	sn("mike")
	//	sn.addFriend("philip", "james")
	//
	//	sn.printUsers
	//	sn.removeUser("mike")
	//	sn.printUsers
	//
	//	object SocialNetwork {
	//		var allUser = Map("" -> "")
	//
	//		def allUserGet():Map[String, String] = {
	//			allUser
	//		}
	//
	//		def addUser(user: String, friend:String = "")= {
	//			val newUser = user -> friend
	//			val tmp = allUser + newUser
	//			allUser = tmp
	//		}
	//
	//		def addFriend(user: String, friend: String) = {
	////			val tmp1 = allUser.filterKeys(_.equals(user))
	////			val tmp = allUser - (user)
	//			val oldFriendList = allUser(user)
	//			val newFriendsList = oldFriendList+ " "+ friend
	//			removeUser(user)
	//			addUser(user, newFriendsList)
	////			allUser(user) = newFriendsList
	////			println("Inside : " + tmp)
	//		}
	//
	//		def removeUser(user: String) = {
	//			if ((allUser.filterKeys(_.equals(user))).isEmpty) {
	//				println("ERROR REMOVING USER")
	//			}
	//			else
	//				allUser = allUser - user
	//		}
	//
	//
	//
	//	}
	//
	//	class SocialNetwork {
	//		val ob = SocialNetwork
	//
	//		def apply(user: String) = {
	//			ob.addUser(user)
	//		}
	//		def removeUser(user: String) = {
	//			ob.removeUser(user)
	//		}
	//
	//		def addFriend(user: String, friend: String) = {
	//			ob.addFriend(user,friend)
	//		}
	//
	//		def printUsers = {
	//			println(ob.allUser)
	//		}
	//	}

	def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
		network + (person -> Set())
	}

	def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
		val friendsA = network(a)
		val friendsB = network(b)

		network + (a -> (friendsA + b)) + (b -> (friendsB + a))
	}

	def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
		val friendsA = network(a)
		val friendsB = network(b)

		network + (a -> (friendsA - b)) + (b -> (friendsB - a))
	}

	def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
		def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
			if (friends.isEmpty) networkAcc
			else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

		val unfriended = removeAux(network(person), network)
		unfriended - person

	}
}



