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
}
