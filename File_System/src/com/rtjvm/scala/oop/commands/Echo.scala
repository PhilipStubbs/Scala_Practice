package com.rtjvm.scala.oop.commands
import com.rtjvm.scala.oop.files.{Directory, File}
import com.rtjvm.scala.oop.filesystem.State

import scala.annotation.tailrec

class Echo(args: Array[String]) extends Command {
	override def apply(state: State): State = {
		if (args.isEmpty || args.length < 1) state
		else if (args.length == 1 ) state.setMessage(args(0) + "\n")
		else {
			val operator = args(args.length - 2)
			val filename = args(args.length - 1)
			val contents = createContent(args, args.length - 2)

			if (">>".equals(operator))
				doEcho(state, contents, filename, true)
			else if (">".equals(operator))
				doEcho(state, contents, filename, false)
			else
				state.setMessage(createContent(args, args.length) + "\n")
		}
	}

	def getRootAfterEcho(currentDirectory: Directory, path: List[String], contents: String, append: Boolean):Directory = {
		if (path.isEmpty || path.length < 1) currentDirectory
		else if (path.tail.isEmpty) {
			val dirEntry = currentDirectory.findEntry(path.head)

			if (dirEntry == null) {
				currentDirectory.addEntry(new File(currentDirectory.path, path.head, contents))
			}
			else if (dirEntry.isDirectory ) currentDirectory
			else
				if (append) currentDirectory.replaceEntry(path.head, dirEntry.asFile.appendContents(contents))
				else currentDirectory.replaceEntry(path.head, dirEntry.asFile.setContents(contents))
		}
		else {
			val nextDirectory = currentDirectory.findEntry(path.head).asDirectory
			val newNextDirectory = getRootAfterEcho(nextDirectory, path.tail, contents, append)

			if (newNextDirectory == newNextDirectory) currentDirectory
			else currentDirectory.replaceEntry(path.head, newNextDirectory)
		}
	}

	def doEcho(state: State, contents: String, filename: String, append: Boolean): State = {
		if (filename.contains(Directory.SEPARATOR))
			state.setMessage("Echo: Filename cannot contail separators")
		else {
			val newRoot: Directory = getRootAfterEcho(state.root, state.wd.getAllFoldersInPath :+ filename, contents, append)
			if (newRoot == state.root)
				state.setMessage(filename + ": no such file")
			else
				State(newRoot, newRoot.findDescendant(state.wd.getAllFoldersInPath))
		}
	}

	def createContent(args: Array[String], topIndex: Int): String = {
		@tailrec
		def createContentHelper(currentIndex: Int, accum: String): String = {
			if (currentIndex >= topIndex) accum
			else createContentHelper(currentIndex+1, accum + " " + args(currentIndex))
		}
		createContentHelper(0, "")
	}

}
