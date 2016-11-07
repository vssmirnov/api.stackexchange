package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Model UserType from site of http://api.stackexchange.com</p>
 */
public enum UserType {
    /// <summary>
    /// unregistered
    /// </summary>
    unregistered,

    /// <summary>
    /// registered
    /// </summary>
    registered,

    /// <summary>
    /// moderator
    /// </summary>
    moderator,

    /// <summary>
    /// does_not_exist
    /// </summary>
    does_not_exist
}
