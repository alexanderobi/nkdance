package com.nkdanceservices.common.utils

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by alexanderobi on 1/30/17.
  */
object ConfigUtil {

  var config = ConfigFactory.load()

  def apply() = config

  def apply(extraConfig:Config) = extraConfig.withFallback(config)
}
