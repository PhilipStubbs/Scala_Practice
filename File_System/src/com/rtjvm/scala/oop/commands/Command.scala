package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.filesystem.State

trait Command extends (State => State){

//	def apply(state: State): State

	def findAbsolutePath(name: String, state: State): String = {
		val wd = state.wd
		if (name.startsWith(Directory.SEPARATOR)) name
		else if (wd.isRoot) wd.path + name
		else wd.path + Directory.SEPARATOR + name
	}
}

object Command {

	val MKDIR = "mkdir"
	val LS = "ls"
	val PWD = "pwd"
	val TOUCH = "touch"
	val CD = "cd"
	val RM = "rm"
	val ECHO = "echo"
	val CAT = "cat"

	def emptyCommand: Command = new Command {
		override def apply(state: State):State = state
	}

	def incompleteCommand(name: String) : Command = new Command {
		override def apply(state: State): State = {
			state.setMessage(name + ": Incomplete Command\n")
		}
	}

	def from(input: String): Command = {

		val token: Array[String] = input.split(" ")

		if (input.isEmpty || token.isEmpty) emptyCommand
		else token(0) match {
			case MKDIR =>
				if (token.length < 2) incompleteCommand(MKDIR)
				else new Mkdir(token(1))

			case LS =>
				new Ls

			case PWD =>
				new Pwd

			case TOUCH =>
				if (token.length < 2) incompleteCommand(TOUCH)
				else new Touch(token(1))

			case CD =>
				if (token.length < 2) incompleteCommand(CD)
				else new Cd(token(1))

			case RM =>
				if (token.length < 2) incompleteCommand(RM)
				else new Rm(token(1))

			case ECHO =>
				if (token.length < 2) incompleteCommand(ECHO)
				else new Echo(token.tail)

			case CAT =>
				if (token.length < 2) incompleteCommand(CAT)
				else new Cat(token(1))

			case _ =>
				new UnknownCommand

		}

	}

}