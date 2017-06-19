package com.nkdanceservices.common.utils

import com.github.tminglei.slickpg._
import slick.basic.Capability
import slick.jdbc.JdbcCapabilities

/**
  * Created by alexanderobi on 2/9/17.
  * Postgres Extensions
  */
trait PostgresExtension extends ExPostgresProfile
  with PgDate2Support with PgSearchSupport with PgHStoreSupport with PgArraySupport with PgRangeSupport with PgDateSupportJoda {

  override protected def computeCapabilities: Set[Capability] =
    super.computeCapabilities + JdbcCapabilities.insertOrUpdate

  override val api = MyAPI

  object MyAPI extends API with ArrayImplicits
    with DateTimeImplicits
    with JodaDateTimeImplicits
    with HStoreImplicits
    with SearchImplicits
    with SearchAssistants
    with RangeImplicits {
    implicit val strListTypeMapper = new SimpleArrayJdbcType[String]("text").to(_.toList)
  }

}
object PostgresExtension extends PostgresExtension