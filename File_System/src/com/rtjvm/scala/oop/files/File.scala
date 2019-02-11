package com.rtjvm.scala.oop.files

import com.rtjvm.scala.oop.filesystem.FilesystemException

class File(override val parentPath:String, override val  name: String, contents: String)
	extends DirEntry(parentPath, name) {

//	def path: String = parentPath + Directory.SEPARATOR + name

	override def asDirectory: Directory =
		throw new FilesystemException("A File cannot be converted to a directory")

	override def asFile: File = this

	override def getType: String = "File"

	def isDirectory: Boolean = false
	def isFile: Boolean = true
}

object File {

	def empty(parentPath: String, name: String): File = {
		new File(parentPath, name, "")
	}
}