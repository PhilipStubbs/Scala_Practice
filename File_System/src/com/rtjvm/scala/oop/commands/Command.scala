package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Command {

	def apply(state: State): State
}

object Command {

	val MKDIR = "mkdir"
	val LS = "ls"
	val PWD = "pwd"
	val TOUCH = "touch"
	val CD = "cd"

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
		else if (MKDIR.equals(token(0))) {
			if (token.length < 2) incompleteCommand(MKDIR)
			else new Mkdir(token(1))
		}
		else if (LS.equals(token(0))){
			new Ls
		}
		else if (PWD.equals(token(0))){
			new Pwd
		}
		else if (TOUCH.equals(token(0))){
			if (token.length < 2) incompleteCommand(TOUCH)
			else new Touch(token(1))
		}
		else if (CD.equals(token(0))) {
			if (token.length < 2) incompleteCommand(CD)
			else new Cd(token(1))
		}
		else new UnknownCommand
	}

}