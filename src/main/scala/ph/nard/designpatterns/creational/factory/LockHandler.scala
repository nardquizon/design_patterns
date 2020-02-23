package ph.nard.designpatterns.creational.factory

import java.io.File

import scala.collection.mutable
import scala.util.Try

/**
  * The factory method is used to offer a single interface to instantiate one of the multiple classes.
  * Do NOT expose to the creation logic to the client.
  * Client should always refer to a newly created object with the help of a common interface.
  */
trait LockHandler {

  /**
    * Try to acquire lock on a given key
    */
  def acquireLock(key: String): Try[Boolean]

  /**
    * Try to release lock on a given key
    */
  def releaseLock(key: String): Try[Boolean]
}

object LockHandler {

  // Apply will serve as the factory method.
  def apply(): LockHandler = new FileBasedLockHandler()

  /**
    * This LockHandler implementation should handle leftover locks but this is just an example so it's okay.
    * Hide the constructor to to FileBasedLockHandler.
    */
  private[LockHandler] case class FileBasedLockHandler() extends LockHandler {
    import FileBasedLockHandler._

    private val lockMapping: mutable.Map[String, String] = mutable.Map()

    override def acquireLock(key: String): Try[Boolean] = synchronized {
      Try {
        val lockFile = new File(s"$BaseDir/$key")

        if (lockFile.exists()) {
          false
        } else {
          val result = lockFile.createNewFile()
          if (result) {
            lockMapping += key -> Thread.currentThread().getName
          }

          result
        }
      }
    }

    override def releaseLock(key: String): Try[Boolean] = Try {
      val lockFile = new File(s"$BaseDir/$key")

      val release =
        for {
          lockHolder <- lockMapping.get(key)
          if lockHolder == Thread.currentThread().getName
        } yield {
          if (lockFile.exists()) {
            lockFile.delete()
          } else {
            false
          }
        }

      release.getOrElse(
        throw new IllegalStateException(
          "Can't release lock from different thread."))
    }
  }

  object FileBasedLockHandler {
    val BaseDir = "/tmp/"
  }
}
