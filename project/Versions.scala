package org.scalameta
package build

object Versions {
  val Scala211Versions = getVersions(2, 11, 12 to 12)
  val Scala212Versions = getVersions(2, 12, 17 to 20)
  val Scala213Versions = getVersions(2, 13, 13 to 16)
  val Scala3Version = "3.3.6"
  val Scala3NextVersion = "3.7.1"
  val LatestScala211 = Scala211Versions.head
  val LatestScala212 = Scala212Versions.head
  val LatestScala213 = Scala213Versions.head
  val LatestScala213ForJS = "2.13.16"
  val EarliestScala211 = Scala211Versions.last
  val EarliestScala212 = Scala212Versions.last
  val EarliestScala213 = Scala213Versions.last
  val AllScala2Versions = Scala213Versions ++ Scala212Versions ++ Scala211Versions
  val AllScalaVersions = AllScala2Versions :+ Scala3Version
  val EarliestScala2Versions = Seq(EarliestScala213, EarliestScala212, EarliestScala211)
  val EarliestScalaVersions = EarliestScala2Versions :+ Scala3Version
  val LatestScala2Versions = Seq(LatestScala213, LatestScala212, LatestScala211)

  // returns versions from newest to oldest
  private def getVersions(major: Int, minor: Int, range: Range) = {
    if (range.length > 4)
      throw new Exception(s"Too many versions for scala-$major.$minor: ${range.length} > 4")
    val desc = if (range.step > 0) range.reverse else range
    desc.map(x => s"$major.$minor.$x")
  }

}
