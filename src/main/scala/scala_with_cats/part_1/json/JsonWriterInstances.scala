package scala_with_cats.part_1.json

object JsonWriterInstances {

  implicit val stringWriter: JsonWriter[String] = (value: String) => JsString(value)

  implicit val personWriter: JsonWriter[Person] =
    (value: Person) =>
      JsObject(
        Map(
          "name"  -> JsString(value.name),
          "email" -> JsString(value.email)
        )
      )

  /*
    implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] = new JsonWriter[Option[A]] {
    override def write(value: Option[A]): Json = value match {
      case Some(a) => writer.write(a)
      case None    => JsNull
    }
  }
  */

  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] = {
    case Some(a) => writer.write(a)
    case None => JsNull
  }
}
