package com.rtjvm.scala.oop.files

abstract class DirEntry(val parentPath: String, val name: String) {
	def path: String = {
		if (parentPath == ROOT_PATH) Directory.SEPARATOR + name
		else parentPath + Directory.SEPARATOR + name
	}
	val ROOT_PATH = "/"
	def asDirectory: Directory
	def asFile: File

	def isDirectory:Boolean
	def isFile:Boolean

	def getType: String
}
