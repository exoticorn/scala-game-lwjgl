package de.exoticorn.scalagame

import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.ARBShaderObjects._
import org.lwjgl.opengl.ARBVertexShader._
import org.lwjgl.opengl.ARBFragmentShader._

final object GLES2 {
  val GL_NO_ERROR = GL11.GL_NO_ERROR
  
  val GL_COLOR_BUFFER_BIT = GL11.GL_COLOR_BUFFER_BIT
  val GL_DEPTH_BUFFER_BIT = GL11.GL_DEPTH_BUFFER_BIT

  val GL_TRIANGLES = GL11.GL_TRIANGLES

  val GL_FRAGMENT_SHADER = GL_FRAGMENT_SHADER_ARB
  val GL_VERTEX_SHADER = GL_VERTEX_SHADER_ARB
  
  def glClearColor(r: Float, g: Float, b: Float, a: Float) = GL11.glClearColor(r, g, b, a)
  def glClear(mask: Int) = GL11.glClear(mask)
  def glDrawArrays(primitive: Int, start: Int, count: Int) = GL11.glDrawArrays(primitive, start, count)
  def glGetError() = GL11.glGetError()

  def glCreateShader(t: Int) = glCreateShaderObjectARB(t)
  def glShaderSource(shader: Int, source: String) = glShaderSourceARB(shader, source)
  def glCompileShader(shader: Int) = glCompileShaderARB(shader)
  def glCreateProgram() = glCreateProgramObjectARB()
  def glAttachShader(program: Int, shader: Int) = glAttachObjectARB(program, shader)
  def glLinkProgram(program: Int) = glLinkProgramARB(program)
  def glUseProgram(program: Int) = glUseProgramObjectARB(program)

  def glGetAttribLocation(program: Int, attrib: String) = glGetAttribLocationARB(program, attrib)
  def glVertexAttribPointer(attr: Int, size: Int, normalize: Boolean, stride: Int, buffer: java.nio.FloatBuffer) = glVertexAttribPointerARB(attr, size, normalize, stride, buffer)
  def glEnableVertexAttribArray(attr: Int) = glEnableVertexAttribArrayARB(attr)
  def glDisableVertexAttribArray(attr: Int) = glDisableVertexAttribArrayARB(attr)

  def glGetUniformLocation(program: Int, name: String) = glGetUniformLocationARB(program, name)
  def glUniform1f(location: Int, v0: Float) = glUniform1fARB(location, v0)
  def glUniform1f(location: Int, v0: Double) = glUniform1fARB(location, v0.asInstanceOf[Float])
  def glUniform2f(location: Int, v0: Float, v1: Float) = glUniform2fARB(location, v0, v1)
  def glUniform2f(location: Int, v0: Double, v1: Double) = glUniform2fARB(location, v0.asInstanceOf[Float], v1.asInstanceOf[Float])
  def glUniform3f(location: Int, v0: Float, v1: Float, v2: Float) = glUniform3fARB(location, v0, v1, v2)
  def glUniform3f(location: Int, v0: Double, v1: Double, v2: Double) = glUniform3fARB(location, v0.asInstanceOf[Float], v1.asInstanceOf[Float], v2.asInstanceOf[Float])
  def glUniform4f(location: Int, v0: Float, v1: Float, v2: Float, v3: Float) = glUniform4fARB(location, v0, v1, v2, v3)
  def glUniform4f(location: Int, v0: Double, v1: Double, v2: Double, v3: Double) = glUniform4fARB(location, v0.asInstanceOf[Float], v1.asInstanceOf[Float], v2.asInstanceOf[Float], v3.asInstanceOf[Float])
  def glUniformMatrix2(location: Int, transpose: Boolean, matrix: java.nio.FloatBuffer) = glUniformMatrix2ARB(location, false, matrix)
  def glUniformMatrix3(location: Int, transpose: Boolean, matrix: java.nio.FloatBuffer) = glUniformMatrix3ARB(location, false, matrix)
  def glUniformMatrix4(location: Int, transpose: Boolean, matrix: java.nio.FloatBuffer) = glUniformMatrix4ARB(location, false, matrix)
}
