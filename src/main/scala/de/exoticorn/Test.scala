package de.exoticorn

import de.exoticorn.scalagame.GLES2._

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.{ Display, DisplayMode }

object Test extends App {
  def compileShader(shaderType: Int, source: String) = {
    val shader = glCreateShader(shaderType)
    glShaderSource(shader, source)
    glCompileShader(shader)
//    checkLog(shader)
    shader
  }

  def linkProgram(vertexShader: Int, fragmentShader: Int) = {
    val program = glCreateProgram()
    glAttachShader(program, vertexShader)
    glAttachShader(program, fragmentShader)
    glLinkProgram(program)
//    checkLog(program)
    program
  }

  def checkError() {
    val error = glGetError()
    if(error != GL_NO_ERROR) {
      printf("glGetError() = %04x\n", error)
    }
  }
  
  Display.setDisplayMode(new DisplayMode(640, 480))
  Display.create()

  val vertexShader = compileShader(GL_VERTEX_SHADER, "attribute vec2 position; void main() { gl_Position = vec4(position, 0, 1); }")
  val fragmentShader = compileShader(GL_FRAGMENT_SHADER, "void main() { gl_FragColor = vec4(1, 0, 0, 1); }")
  val program = linkProgram(vertexShader, fragmentShader)

  checkError()

  val byteBuffer = java.nio.ByteBuffer.allocateDirect(6*4)
  byteBuffer.order(java.nio.ByteOrder.nativeOrder())
  val vertexBuffer = byteBuffer.asFloatBuffer()
  vertexBuffer.put(Array(-1.0f, -1.0f, 1.0f, -1.0f, 0.0f, 1.0f))
  vertexBuffer.rewind()

  val positionAttribute = glGetAttribLocation(program, "position")

  var t = 0.0
  
  while(!Display.isCloseRequested()) {
    glClearColor(1, 0, 1, 1)
    glClear(GL_COLOR_BUFFER_BIT)

    byteBuffer.putFloat(16, math.sin(t).asInstanceOf[Float])
//    vertexBuffer.put(0, math.sin(t).asInstanceOf[Float])
    t += math.Pi / 60

    glUseProgram(program)
    glVertexAttribPointer(positionAttribute, 2, false, 8, vertexBuffer)
    glEnableVertexAttribArray(positionAttribute)
    glDrawArrays(GL_TRIANGLES, 0, 3)
    checkError()

    Display.update()
  }

  Display.destroy()
}
