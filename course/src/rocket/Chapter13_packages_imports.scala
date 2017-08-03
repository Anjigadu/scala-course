package rocket {
  package navigator {
    class Navigator { //rocket.navigator.Navigator
      new Rocket //Ciudat ca merge, Merge doar pentru ca ai folosit package { }
    }
  }

  class Rocket

  object Chapter13_packages_imports extends App {
    new rocket.navigator.Navigator

    new navigator.Navigator // package paths can be relative

  }

}
