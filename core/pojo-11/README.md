# Method call order in IoC Container
1. Create the instance using the Constructor or Factory method
1. Set the value and properties into the Bean
1. Call the setter method which is implemented from Aware interfaces.
1. Invoke the initialization callback method about the Bean instance at the `postProcessBeforeInitialization()`
1. Pass the Bean instance to the `postProcessAfterInitialization`
1. Now, ready to use the Bean.
1. Call the destroying callback method when the IoC Container is terminated.